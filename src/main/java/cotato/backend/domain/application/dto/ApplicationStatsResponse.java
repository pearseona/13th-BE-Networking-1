package cotato.backend.domain.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApplicationStatsResponse {
    private int period;
    private long totalCount;
    private long planCount;
    private long designCount;
    private long frontendCount;
    private long backendCount;
}
