package sit.integrated.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.integrated.project.models.JwtUser;

public interface JwtUserRepositories extends JpaRepository<JwtUser,String> {
}
