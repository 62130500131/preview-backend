package sit.integrated.project.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "JwtUser")
@Getter
@Setter
public class JwtUser extends User implements Serializable {
    @Autowired
    public JwtUser(){
        super("anonymous","",new ArrayList<>());
    }
    @Autowired
    public JwtUser(String username, String password, Collection<?extends
            GrantedAuthority> authorities){
        super(username,password,authorities);
    }

    @Id
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
}
