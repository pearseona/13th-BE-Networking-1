package cotato.backend.domain.applicant.repository;

import cotato.backend.domain.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    // 휴대폰 번호로 동일인 식별
    Optional<Applicant> findByPhoneNumber(String phoneNumber);
}
