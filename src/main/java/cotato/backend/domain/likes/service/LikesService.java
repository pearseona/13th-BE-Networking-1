package cotato.backend.domain.likes.service;

import cotato.backend.domain.admin.repository.AdminRepository;
import cotato.backend.domain.application.repository.ApplicationRepository;
import cotato.backend.domain.entity.Admin;
import cotato.backend.domain.entity.Application;
import cotato.backend.domain.entity.Likes;
import cotato.backend.domain.likes.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikesService {
    private final LikesRepository likesRepository;
    private final ApplicationRepository applicationRepository;
    private final AdminRepository adminRepository;

    /* 좋아요 로직 */
    public String toggleLike(Long applicationId, Long adminId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new IllegalArgumentException("해당 지원서가 없습니다."));

        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("해당 관리자가 없습니다."));

        // 이미 좋아요를 눌렀는지 확인
        Optional<Likes> existingLike = likesRepository.findByAdminAndApplication(admin, application);

        if (existingLike.isPresent()) {
            // 이미 있다면 취소 (삭제)
            likesRepository.delete(existingLike.get());
            application.removeLike();
            return "좋아요 취소 완료";
        } else {
            // 없다면 추가
            likesRepository.save(new Likes(admin, application));
            application.addLike();
            return "좋아요 추가 완료";
        }
    }
}
