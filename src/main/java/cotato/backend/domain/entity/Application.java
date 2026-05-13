// 지원서
package cotato.backend.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import cotato.backend.domain.entity.enums.Part;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Applicant applicant;

    @Min(value = 1, message = "기수는 1 이상이어야 합니다.")
    private int period;

    @Enumerated(EnumType.STRING)
    private Part part;

    @Min(0) @Max(10)
    private int ability;

    @Min(0) @Max(10)
    private int passion;

    private int likeCount = 0;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime applicationTime;

    @Builder
    public Application(Applicant applicant, int period, Part part, int ability,
                       int passion, LocalDateTime applicationTime) {
        this.applicant = applicant;
        this.period = period;
        this.part = part;
        this.ability = ability;
        this.passion = passion;
        this.applicationTime = applicationTime;
    }

    public void addLike() {
        this.likeCount++;
    }
}
