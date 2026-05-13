package cotato.backend.domain.likes.controller;

import cotato.backend.domain.likes.service.LikesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "좋아요", description = "서류 좋아요 토글 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/likes")
public class LikesController {
    private final LikesService likesService;

    /* 좋아요 API */
    @PostMapping("/{applicationId}")
    public ResponseEntity<String> toggleLike(
            @PathVariable Long applicationId,
            @RequestParam Long adminId
    ) {
        String result = likesService.toggleLike(applicationId, adminId);
        return ResponseEntity.ok(result);
    }
}
