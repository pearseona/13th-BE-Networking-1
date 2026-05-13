package cotato.backend.domain.application.repository;

import cotato.backend.domain.entity.Application;
import cotato.backend.domain.entity.enums.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // 기수별 조회
    Page<Application> findAllByPeriod(int period, Pageable pageable);

    // 전체 조회
    Page<Application> findAll(Pageable pageable);

    // 기수별 파트 인원수 세기
    long countByPeriodAndPart(int period, Part part);

    // 기수별 전체 인원수 세기
    long countByPeriod(int period);
}
