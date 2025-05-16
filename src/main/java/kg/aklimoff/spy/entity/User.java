package kg.aklimoff.spy.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails{
    @Id
    private String id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "authority_id", referencedColumnName = "id")
    private Authority authority;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Game> createdGames;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users", cascade = CascadeType.ALL)
    private List<Game> games = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(authority.getRole()));
    }

    @Override
    public String getUsername() {
        return nickname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
