package be.technifutur.jpa.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "territories")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Territory {

    @Id
    @Column(name = "territory_id")
    private String id;

    @Column(name = "territory_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToMany(mappedBy = "territories")
    private Set<Employee> employees = new LinkedHashSet<>();
}
