package cotato.backend.domain.likes.controller;

import cotato.backend.domain.likes.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/likes")
public class LikesController {
    private final LikesService likesService;

    @PostMapping("/{applicationId}")
    public ResponseEntity<Void> addLike(
            @PathVariable Long applicationId,
            @RequestParam Long adminId
    ) {
        likesService.addLike(applicationId, adminId);
        return ResponseEntity.ok().build();
    }
}
