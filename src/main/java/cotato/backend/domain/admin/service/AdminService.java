package cotato.backend.domain.admin.service;

import cotato.backend.domain.admin.dto.AdminCreateRequest;
import cotato.backend.domain.admin.dto.AdminResponse;
import cotato.backend.domain.admin.dto.AdminUpdateRequest;
import cotato.backend.domain.admin.repository.AdminRepository;
import cotato.backend.domain.entity.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {
    private final AdminRepository adminRepository;

    /* 운영진 상세 조회 로직 */
    public AdminResponse getAdmin(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("해당 운영진이 존재하지 않습니다."));
        return AdminResponse.from(admin);
    }

    /* 운영진 정보 수정 로직 */
    @Transactional
    public void updateAdmin(Long adminId, AdminUpdateRequest request) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("해당 운영진이 존재하지 않습니다."));

        // 엔티티 내부에 미리 만들어두신 updateInfo 메서드 활용!
        admin.updateInfo(request.getName(), request.getAge(), request.getPhoneNumber(), request.getRole());
    }

    /* 운영진 등록 로직 */
    @Transactional
    public Long createAdmin(AdminCreateRequest request) {
        Admin admin = Admin.builder()
                .name(request.getName())
                .age(request.getAge())
                .phoneNumber(request.getPhoneNumber())
                .role(request.getRole())
                .build();

        return adminRepository.save(admin).getId();

    }
}
