package cotato.backend.domain.admin.controller;

import cotato.backend.domain.admin.dto.AdminCreateRequest;
import cotato.backend.domain.admin.dto.AdminResponse;
import cotato.backend.domain.admin.dto.AdminUpdateRequest;
import cotato.backend.domain.admin.service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "운영진", description = "운영진 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService adminService;

    /* 운영진 상세 조회 API */
    @GetMapping("/{adminId}")
    public ResponseEntity<AdminResponse> getAdmin(@PathVariable Long adminId) {
        return ResponseEntity.ok(adminService.getAdmin(adminId));
    }

    /* 운영진 정보 수정 */
    @PatchMapping("/{adminId}")
    public ResponseEntity<Void> updateAdmin(
            @PathVariable Long adminId,
            @RequestBody AdminUpdateRequest request
    ) {
        adminService.updateAdmin(adminId, request);
        return ResponseEntity.ok().build();
    }

    /* 운영진 등록 API */
    @PostMapping
    public ResponseEntity<Long> createAdmin(@Valid @RequestBody AdminCreateRequest request) {
        Long adminId = adminService.createAdmin(request);
        return ResponseEntity.ok(adminId);
    }
}
