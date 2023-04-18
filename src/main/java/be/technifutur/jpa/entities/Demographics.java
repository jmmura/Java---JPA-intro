package be.technifutur.jpa.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customer_demographics")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Demographics {

    @Id
    @Column(name = "customer_type_id")
    private String id;

    @Column(name = "customer_desc")
    private String desc;

    @ManyToMany(mappedBy = "types")
    private List<Customer> customers;




}
