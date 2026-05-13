package cotato.backend.domain.applicant.controller;

import cotato.backend.domain.applicant.dto.ApplicantResponse;
import cotato.backend.domain.applicant.dto.ApplicantUpdateRequest;
import cotato.backend.domain.applicant.service.ApplicantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "지원자", description = "지원자 정보 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/applicants")
public class ApplicantController {
    private final ApplicantService applicantService;

    /* 지원자 정보 조회 API */
    @GetMapping("/{applicantId}")
    public ResponseEntity<ApplicantResponse> getApplicant(@PathVariable Long applicantId) {
        return ResponseEntity.ok(applicantService.getApplicant(applicantId));
    }

    /* 지원자 정보 수정 API */
    @PatchMapping("/{applicantId}")
    public ResponseEntity<Void> updateApplicant(
            @PathVariable Long applicantId,
            @RequestBody ApplicantUpdateRequest request
    ) {
        applicantService.updateApplicant(applicantId, request);
        return ResponseEntity.ok().build();
    }
}
