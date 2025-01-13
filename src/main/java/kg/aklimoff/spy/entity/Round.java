package kg.aklimoff.spy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "rounds")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Round {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "word_id", referencedColumnName = "id")
    private Word word;
}
