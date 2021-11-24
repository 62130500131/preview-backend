package sit.integrated.project.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(name = "Users")
@Getter@Setter
public class Users {
    @Id

    @Column( name ="userId")
    private Integer userId;

    @Column( name ="userName")
    private String userName;

    @Column( name ="userPassword")
    private String userPassword;

    @Column( name ="userFirstName")
    private String userFirstName;

    @Column( name ="userLastName")
    private String userLastName;

    @Column( name ="userEmail")
    private String userEmail;

    @Column( name ="userTel")
    private Integer userTel;

    @Column( name ="userAddress")
    private String userAddress;

    @ManyToOne
    @JoinColumn(name="roles_roleId", nullable=false)
    private Roles roleId;

}
