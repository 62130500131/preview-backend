package sit.integrated.project.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "Feedback")
@Getter@Setter

public class Feedback {

    @Id

    @Column( name ="feedbackId")
    private Integer feedbackId;

    @Column( name ="message")
    private String message;

    @ManyToOne
    @JoinColumn(name="users_userId", nullable=false)
    private Users usersId;

    @ManyToOne
    @JoinColumn(name="products_productId", nullable=false)
    private Products productsId;


}
