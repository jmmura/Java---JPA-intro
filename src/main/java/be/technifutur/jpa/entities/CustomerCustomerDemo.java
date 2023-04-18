package be.technifutur.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer_customer_demo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCustomerDemo {

    @Id
    @Column(name = "customer_id")
    private String id;

    @Id
    @Column(name = "customer_type_id")
    private String typeId;

    @JoinColumn(name = "customer_type_id")
    @ManyToOne
    private Demographics customerDemographics;
}
