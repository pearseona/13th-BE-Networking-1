// 지원자
package cotato.backend.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 10)
    @Pattern(regexp = "^[가-힣]*$", message = "한글만 입력 가능합니다.")
    private String name;

    @Min(22) @Max(30)
    private int age;

    @NotBlank
    @Pattern(regexp = "^010\\d{8}$", message = "010으로 시작하는 11자리 숫자여야 합니다.")
    @Column(unique = true)
    private String phoneNumber;

    @Builder
    public Applicant(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public void updateInfo(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

}
