package be.technifutur.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "product_id")
    private long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "quantity_per_unit")
    private String qtPerUnit;

    @Column(name = "unit_price")
    private float unit_price;

    @Column(name = "units_in_stock")
    private int stock;

    @Column(name = "units_on_order")
    private int order;

    @Column(name = "reorder_level")
    private int reorder_level;

    private int discontinued;   //pas besoin de mettre @Column car la variable
                                    //a le même nom que la colonne dans la db

    @ManyToOne //plusieurs produits -> 1 supplier
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;


    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();


    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
