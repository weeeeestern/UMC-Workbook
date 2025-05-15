package umc.spring.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MissionResponseDTO {
     Long missionId;
     Long storeId;
     Integer reward;
     String missionSpec;
    LocalDateTime createdAt;

}
