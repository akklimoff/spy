package kg.aklimoff.spy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
}
