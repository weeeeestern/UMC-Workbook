package umc.spring.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.study.validation.annotation.NotChallenging;

@Getter
@NoArgsConstructor
public class MemberMissionRequestDTO {

    @NotNull(message = "멤버 ID는 필수입니다.")
    private Long memberId;

    @NotNull(message = "미션 ID는 필수입니다.")
    @NotChallenging //  커스텀 어노테이션
    private Long missionId;
}