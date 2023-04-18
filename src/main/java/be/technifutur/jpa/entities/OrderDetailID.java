package be.technifutur.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;

@Embeddable
@Data
public class OrderDetailID implements Serializable {

    @GeneratedValue
    private static final long serialVersionID = 1L;

    private long orderId;

    private long productId;
}
