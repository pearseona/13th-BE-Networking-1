package cotato.backend.domain.admin.dto;

import cotato.backend.domain.entity.enums.Role;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdminCreateRequest {

    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @Min(value = 20, message = "운영진은 20세 이상이어야 합니다.")
    private int age;

    @NotBlank
    @Pattern(regexp = "^010\\d{8}$", message = "010으로 시작하는 11자리 숫자여야 합니다.")
    private String phoneNumber;

    private Role role;
}
