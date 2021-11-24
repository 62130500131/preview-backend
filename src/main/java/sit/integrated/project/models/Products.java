package sit.integrated.project.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
@Entity
@Table(name = "Products")
@Getter@Setter
public class Products {

    @Id

    @Column( name ="productId")
    private Integer productId;


    @Column(name ="productName")
    private String productName;


    @Column(name ="productType")
    private String productType;


    @Column(name ="productDescription")
    private String productDescription;


    @Column(name ="productPrice")
    private double productPrice;


    @Column(name ="productGender")
    private String productGender;


    @Column(name ="productManufactured")
    private LocalDate date  ;

    @ManyToOne
    @JoinColumn(name="brands_brandId", nullable=false)
    private Brands BrandId;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "Products_Colors" ,
            joinColumns = @JoinColumn(name = "products_productId"),
            inverseJoinColumns = @JoinColumn(name = "colors_colorId")
    )

    private List<Colors> ProductColors= new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="users_userId", nullable=false)
    private Users UserId;

}

