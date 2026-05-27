package cotato.backend.domain.admin.dto;

import cotato.backend.domain.admin.repository.AdminRepository;
import cotato.backend.domain.entity.Admin;
import cotato.backend.domain.entity.enums.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AdminResponse {
    private String name;
    private int age;
    private String phoneNumber;
    private Role role;

    public static AdminResponse from(Admin admin) {
        return AdminResponse.builder()
                .name(admin.getName())
                .age(admin.getAge())
                .phoneNumber(admin.getPhoneNumber())
                .role(admin.getRole())
                .build();
    }
}
