package cotato.backend.domain.admin.dto;

import cotato.backend.domain.entity.enums.Role;
import lombok.Getter;

@Getter
public class AdminUpdateRequest {
    private String name;
    private int age;
    private String phoneNumber;
    private Role role;
}
