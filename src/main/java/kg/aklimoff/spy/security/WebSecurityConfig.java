package kg.aklimoff.spy.security;

import kg.aklimoff.spy.service.impl.AuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class WebSecurityConfig {
    @Autowired
    private AuthUserDetailsService userDetailsService;
    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    // Сам фильтр для валидации JWT
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    // BCryptPasswordEncoder — будем использовать его в DaoAuthenticationProvider
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Настраиваем DaoAuthenticationProvider:
    // он будет дергать userDetailsService и проверять пароли через наш passwordEncoder
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // Получаем AuthenticationManager (он будет знать о DaoAuthenticationProvider)
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Основная конфигурация SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   CorsConfigurationSource corsConfigurationSource
    ) throws Exception {
        http
                // отключаем CSRF для stateless REST
                .csrf(csrf -> csrf.disable())

                // включаем CORS с нашей конфигурацией
                .cors(cors -> cors.configurationSource(corsConfigurationSource))

                // обрабатываем ошибку неавторизованного доступа
                .exceptionHandling(ex -> ex.authenticationEntryPoint(unauthorizedHandler))

                // говорим, что сессий нет, всё через JWT
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // разрешаем свободный доступ к /api/auth/**, всё остальное — аутентификация
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated()
                )

                // регистрируем наш DaoAuthenticationProvider
                .authenticationProvider(authenticationProvider());

        // добавляем фильтр проверки JWT ПЕРЕД UsernamePasswordAuthenticationFilter
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /** Глобальная CORS-конфигурация **/
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        // разрешённый origin Angular-приложения
        config.setAllowedOrigins(List.of("http://localhost:4200"));
        // разрешённые методы
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        // разрешённые заголовки (любой)
        config.setAllowedHeaders(List.of("*"));
        // если используем куки (здесь false, ведь работаем с JWT)
        config.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
