package sit.integrated.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.integrated.project.models.Users;

public interface UsersRepositories extends JpaRepository<Users, Integer> {
    @Query(value = "SELECT max(userId) from Users ")
    public int userLatestId();

}
