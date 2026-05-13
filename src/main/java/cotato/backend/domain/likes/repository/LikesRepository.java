package cotato.backend.domain.likes.repository;

import cotato.backend.domain.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    // 특정 운영진이 특정 서류에 좋아요를 이미 눌렀는지 확인용
    boolean existsByAdminIdAndApplicationId(Long adminId, Long applicationId);
}
