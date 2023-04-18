package be.technifutur.jpa.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "employee_id")
    private long id;

    private String last_name;

    private String first_name;

    private String title;

    @Column(name = "title_of_courtesy")
    private String titleCourtesy;


    private LocalDate birth_date;


    private LocalDate hire_date;

    private String address;

    private String city;


    private String region;


    private String postal_code;

    private String country;

    private String home_phone;

    private String extension;

    private String notes;

    //private byte photo;

    @ManyToOne
    @JoinColumn(name="reports_to")
    private Employee reportsTo;

    @OneToMany(mappedBy = "reportsTo")
    private Set<Employee> subordinates = new LinkedHashSet<>();


    @ManyToMany
    @JoinTable(
            name = "employee_territories",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns =  @JoinColumn(name = "territory_id")
    )
    private Set<Territory> territories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "managedBy")
    private Set<Order> orders = new LinkedHashSet<>();


}
