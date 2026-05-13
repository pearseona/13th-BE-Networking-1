package cotato.backend.domain.likes.repository;

import cotato.backend.domain.entity.Admin;
import cotato.backend.domain.entity.Application;
import cotato.backend.domain.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    // 중복 체크를 위한 메서드
    boolean existsByAdminAndApplication(Admin admin, Application application);
}
