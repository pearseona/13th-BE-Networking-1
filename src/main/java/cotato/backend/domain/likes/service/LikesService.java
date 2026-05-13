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

@Service
@RequiredArgsConstructor
@Transactional
public class LikesService {
    private final LikesRepository likesRepository;
    private final ApplicationRepository applicationRepository;
    private final AdminRepository adminRepository;

    /* 좋아요 로직 */
    public void addLike(Long applicationId, Long adminId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new IllegalArgumentException("해당 지원서가 없습니다."));

        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("해당 관리자가 없습니다."));

        // 중복 좋아요 방지
        if (likesRepository.existsByAdminAndApplication(admin, application)) {
            throw new IllegalStateException("이미 좋아요를 누른 서류입니다.");
        }

        // 좋아요 엔티티 저장
        likesRepository.save(new Likes(admin, application));

        // Application 엔티티의 likeCount 증가 (더티 체킹 이용)
        application.addLike();
    }
}
