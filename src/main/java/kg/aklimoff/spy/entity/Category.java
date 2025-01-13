package kg.aklimoff.spy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Game> games = new ArrayList<>();
}
