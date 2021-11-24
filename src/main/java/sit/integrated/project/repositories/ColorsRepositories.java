package sit.integrated.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.integrated.project.models.Colors;

public interface ColorsRepositories extends JpaRepository<Colors,String> {
}
