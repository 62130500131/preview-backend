package sit.integrated.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import sit.integrated.project.models.Brands;

public interface BrandsRepositories extends JpaRepository<Brands, String> {
}
