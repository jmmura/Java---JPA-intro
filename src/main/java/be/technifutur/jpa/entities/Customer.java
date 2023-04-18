package be.technifutur.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Contactable{

    @Id
    @Column(name = "customer_id")
    private String id;

    @ManyToMany
    @JoinTable(
            name = "customer_customer_demo",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_type_id")
    )
    private List<Demographics> types;


    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;




}

