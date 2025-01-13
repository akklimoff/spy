package kg.aklimoff.spy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "games")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "quantity_of_players")
    private Integer quantityOfPlayers;

    @Column(name = "quantity_of_spies")
    private Integer quantityOfSpies;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by_user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    private List<Round> rounds;
}
