//package kg.aklimoff.spy.config;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerJwtAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import java.io.IOException;
//import java.util.Collection;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    /* ---------- 1) JWT-API ---------- */
//    @Bean @Order(1)
//    public SecurityFilterChain apiChain(HttpSecurity http,
//                                        Filter jwtFilter) throws Exception {
//
//        http.securityMatcher("/api/**")         // ← только /api/**
//                .csrf(csrf -> csrf.disable())        // CSRF не нужен при JWT
//                .sessionManagement(sm ->
//                        sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                "/api/auth/login",
//                                "/api/auth/register"
//                        ).permitAll()
//                        .anyRequest().authenticated())
//                .addFilterBefore(jwtFilter,
//                        UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//    /* ---------- 2) Browser-chain (опц.) ---------- */
//    @Bean @Order(2)
//    public SecurityFilterChain browserChain(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf
//                        .csrfTokenRepository(
//                                CookieCsrfTokenRepository.withHttpOnlyFalse()))
//                .sessionManagement(sm ->
//                        sm.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/account")
//                        .permitAll())
//                .logout(logout -> logout.logoutSuccessUrl("/login"))
//                .authorizeHttpRequests(auth ->
//                        auth.anyRequest().permitAll());
//
//        return http.build();
//    }
//}
//
