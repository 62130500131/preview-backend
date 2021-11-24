package sit.integrated.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.integrated.project.models.Roles;

public interface RolesRepositories extends JpaRepository<Roles, Integer> {
    @Query(value = "SELECT max(roleId) from Roles ")
    public int roleLatestId();
}
