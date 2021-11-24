package sit.integrated.project.repositories;

import org.springframework.data.jpa.repository.Query;
import sit.integrated.project.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepositories extends JpaRepository<Products,Integer> {
    @Query(value = "SELECT max(productId) from Products ")
    public int productLatestId();
}