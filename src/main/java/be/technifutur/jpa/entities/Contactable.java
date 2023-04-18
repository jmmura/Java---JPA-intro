package be.technifutur.jpa.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Data
public  class Contactable {
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