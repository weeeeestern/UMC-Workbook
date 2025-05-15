package umc.spring.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MissionRequestDTO {

    @NotNull(message = "보상은 반드시 입력되어야 합니다.")
    private Integer reward;

    @NotBlank(message = "미션 설명은 공백일 수 없습니다.")
    private String missionSpec;
}
