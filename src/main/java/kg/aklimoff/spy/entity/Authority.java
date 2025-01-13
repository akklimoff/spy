package kg.aklimoff.spy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "authorities")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authority {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "authority", fetch = FetchType.LAZY)
    private List<User> users;
}
