package be.technifutur.jpa.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "suppliers")  //nécessaire ssi le nom de la classe Java est différent de celui de la table dans la dbb
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @Column(name = "supplier_id")
    private long id;


    private String homepage;

    @OneToMany(mappedBy = "supplier")   //1 supplier -> plusieurs products | liaison par 'attributs supplier de la classe product
    private List<Product> products;





    //momentané car pbs avec extends Contactable

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_title")
    private String contactTitle;

    private String address;

    private String city;

    private String region;

    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    private String phone;

    private String fax;
}
