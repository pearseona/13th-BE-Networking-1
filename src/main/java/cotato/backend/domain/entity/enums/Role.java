package cotato.backend.domain.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    PART_JANG("파트장"),
    PLAN_LEADER("기획팀장"),
    PR_LEADER("홍보팀장"),
    VICE_PRESIDENT("부회장"),
    PRESIDENT("회장"),
    EDU_LEADER("교육팀장");

    private final String description;
}
