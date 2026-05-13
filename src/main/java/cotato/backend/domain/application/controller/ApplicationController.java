package cotato.backend.domain.application.controller;

import cotato.backend.domain.application.dto.ApplicationRequest;
import cotato.backend.domain.application.dto.ApplicationStatsResponse;
import cotato.backend.domain.application.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    /* 지원서 등록 API */
    @PostMapping
    public ResponseEntity<Long> createApplication(@RequestBody ApplicationRequest request) {
        Long applicationId = applicationService.saveApplication(request);
        return ResponseEntity.ok(applicationId);
    }

    /* 지원서 목록 조회 API */
    @GetMapping
    public ResponseEntity<?> getApplications(
            @RequestParam(required = false) Integer period,
            @PageableDefault(size = 10, sort = "applicationTime", direction = Sort.Direction.ASC) Pageable pageable) {

        return ResponseEntity.ok(applicationService.findAllApplications(period, pageable));
    }

    /* 파트별 지원자 조회 API */
    @GetMapping("/stats")
    public ResponseEntity<ApplicationStatsResponse> getStats(@RequestParam int period) {
        return ResponseEntity.ok(applicationService.getStats(period));
    }
}
