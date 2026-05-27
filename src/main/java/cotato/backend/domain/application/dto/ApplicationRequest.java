package cotato.backend.domain.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import cotato.backend.domain.entity.enums.Part;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ApplicationRequest {
    private String name;
    private int period;
    private int age;
    private Part part;
    private int ability;
    private int passion;
    private String phoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime applicationTime;
}
