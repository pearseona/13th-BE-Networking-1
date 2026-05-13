package cotato.backend.domain.admin.repository;

import cotato.backend.domain.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
