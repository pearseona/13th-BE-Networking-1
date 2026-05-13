package cotato.backend.domain.application.repository;

import cotato.backend.domain.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Application, Long> {
    // 기수별 조회
    Page<Application> findAllByPeriod(int period, Pageable pageable);

    // 전체 조회
    Page<Application> findAll(Pageable pageable);
}
