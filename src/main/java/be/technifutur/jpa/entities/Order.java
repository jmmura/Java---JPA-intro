package be.technifutur.jpa.entities;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Order {

    @Id
    @Column(name = "order_id")
    private long id;


    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "required_date")
    private LocalDate requiredDate;

    @Column(name = "shipped_date")
    private LocalDate shippedDate;

    private float freight;

    @ManyToOne
    @JoinColumn(name = "ship_via")
    private Shipper shipVia;

    @Column(name = "ship_name")
    private String shipName;

    @Column(name = "ship_address")
    private String shipAddress;

    @Column(name = "ship_city")
    private String shipCity;

    @Column(name = "ship_region")
    private String shipRegion;

    @Column(name = "ship_postal_code")
    private String shipPostalCode;

    @Column(name = "ship_country")
    private String shipCountry;


    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;



    @ManyToMany
    @JoinTable(
            name = "order_details",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new LinkedHashSet<>();


    @ManyToMany(mappedBy = "products")      //Mis ici car order est une entité forte % produit (" on ajoute des produits à une order")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> details = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee managedBy;






}
