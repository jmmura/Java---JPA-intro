package be.technifutur.jpa.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetail {

    @Id
    @EmbeddedId //permet d'utiliser des clés omposites
    private OrderDetailID id;

    @MapsId("productId")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @MapsId("orderId")
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @Column(name = "unit_price")
    private double unitPrice;

    private int quantity;

    private double discount;




}
