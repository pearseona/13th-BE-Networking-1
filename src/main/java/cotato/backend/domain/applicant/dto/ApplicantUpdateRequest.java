package cotato.backend.domain.applicant.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApplicantUpdateRequest {

    @NotBlank
    private String name;

    private int age;

    @NotBlank
    @Pattern(regexp = "^010\\d{8}$", message = "010으로 시작하는 11자리 숫자여야 합니다.")
    private String phoneNumber;
}
