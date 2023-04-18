package be.technifutur.jpa.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "region")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @Column(name = "region_id")
    private long id;

    @Column(name = "region_description")
    private String description;

    @OneToMany(mappedBy = "region")
    private Set<Territory> territories = new LinkedHashSet<>();
}
