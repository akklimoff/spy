package kg.aklimoff.spy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "statuses")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Status {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Game> games;
}
