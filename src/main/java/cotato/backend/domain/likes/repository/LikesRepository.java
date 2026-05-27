package cotato.backend.domain.likes.repository;

import cotato.backend.domain.entity.Admin;
import cotato.backend.domain.entity.Application;
import cotato.backend.domain.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByAdminAndApplication(Admin admin, Application application);
}
