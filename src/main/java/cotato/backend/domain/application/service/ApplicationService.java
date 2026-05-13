package cotato.backend.domain.application.service;

import cotato.backend.domain.applicant.repository.ApplicantRepository;
import cotato.backend.domain.application.dto.ApplicationRequest;
import cotato.backend.domain.application.repository.ApplicationRepository;
import cotato.backend.domain.entity.Applicant;
import cotato.backend.domain.entity.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicantRepository applicantRepository;

    /* 지원자 식별 로직 */
    @Transactional
    public Long saveApplication(ApplicationRequest request) {
        // 휴대폰 번호로 기존 지원자가 있는지 확인
        Applicant applicant = applicantRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseGet(() -> {
                    // 없으면 새로 생성하여 저장
                    Applicant newApplicant = Applicant.builder()
                            .name(request.getName())
                            .age(request.getAge())
                            .phoneNumber(request.getPhoneNumber())
                            .build();
                    return applicantRepository.save(newApplicant);
                });

        // 지원서 생성 및 지원자 연결
        Application application = Application.builder()
                .applicant(applicant)
                .period(request.getPeriod())
                .part(request.getPart())
                .ability(request.getAbility())
                .passion(request.getPassion())
                .applicationTime(request.getApplicationTime())
                .build();

        return applicationRepository.save(application).getId();
    }
}
