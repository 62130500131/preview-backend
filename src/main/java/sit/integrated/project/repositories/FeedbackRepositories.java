package sit.integrated.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.integrated.project.models.Feedback;

public interface FeedbackRepositories extends JpaRepository<Feedback, Integer> {
    @Query(value = "SELECT max(feedbackId) from Feedback ")
    public int feedbackLatestId();
}
