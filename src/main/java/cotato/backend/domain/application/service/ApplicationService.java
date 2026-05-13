package cotato.backend.domain.application.service;

import cotato.backend.domain.applicant.repository.ApplicantRepository;
import cotato.backend.domain.application.dto.ApplicationRequest;
import cotato.backend.domain.application.dto.ApplicationStatsResponse;
import cotato.backend.domain.application.repository.ApplicationRepository;
import cotato.backend.domain.entity.Applicant;
import cotato.backend.domain.entity.Application;
import cotato.backend.domain.entity.enums.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicantRepository applicantRepository;

    /* 지원서 등록 로직 */
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

    /* 지원서 목록 조회 로직 */
    public Object findAllApplications(Integer period, Pageable pageable) {
        if (period != null) {
            return applicationRepository.findAllByPeriod(period, pageable);
        }
        return applicationRepository.findAll(pageable);
    }

    /* 파트별 지원자 조회 로직 */
    @Transactional(readOnly = true)
    public ApplicationStatsResponse getStats(int period) {
        long total = applicationRepository.countByPeriod(period);

        long plan = applicationRepository.countByPeriodAndPart(period, Part.기획);
        long design = applicationRepository.countByPeriodAndPart(period, Part.디자이너);
        long frontend = applicationRepository.countByPeriodAndPart(period, Part.프론트엔드);
        long backend = applicationRepository.countByPeriodAndPart(period, Part.백엔드);

        return ApplicationStatsResponse.builder()
                .period(period)
                .totalCount(total)
                .planCount(plan)
                .designCount(design)
                .frontendCount(frontend)
                .backendCount(backend)
                .build();
    }
}
