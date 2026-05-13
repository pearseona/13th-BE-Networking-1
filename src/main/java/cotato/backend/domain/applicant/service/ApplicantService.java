package cotato.backend.domain.applicant.service;

import cotato.backend.domain.applicant.dto.ApplicantResponse;
import cotato.backend.domain.applicant.dto.ApplicantUpdateRequest;
import cotato.backend.domain.applicant.repository.ApplicantRepository;
import cotato.backend.domain.entity.Applicant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicantService {
    private final ApplicantRepository applicantRepository;

    /* 지원자 정보 조회 로직 */
    public ApplicantResponse getApplicant(Long applicantId) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new IllegalArgumentException("해당 지원자가 존재하지 않습니다."));
        return ApplicantResponse.from(applicant);
    }

    /* 지원자 정보 수정 로직 */
    @Transactional
    public void updateApplicant(Long applicantId, ApplicantUpdateRequest request) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new IllegalArgumentException("해당 지원자가 존재하지 않습니다."));

        applicant.updateInfo(request.getName(), request.getAge(), request.getPhoneNumber());
    }
}
