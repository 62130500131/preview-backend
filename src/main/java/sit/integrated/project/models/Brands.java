package sit.integrated.project.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(name = "Brands")
@Getter@Setter
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brandId")
    private String brandId;

    @Column(name = "brandName")
    private String brandName;
}
