// 운영진
package cotato.backend.domain.entity;

import cotato.backend.domain.entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private int age;

    @NotBlank
    @Pattern(regexp = "^010\\d{8}$")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Admin(String name, int age, String phoneNumber, Role role) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    // 운영진은 모든 정보 수정 가능
    public void updateInfo(String name, int age, String phoneNumber, Role role) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

}
