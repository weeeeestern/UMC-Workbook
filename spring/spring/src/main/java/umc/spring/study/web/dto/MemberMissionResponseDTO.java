package umc.spring.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MemberMissionResponseDTO {
     Long memberMissionId;
     Long memberId;
     Long missionId;
     String status;
    LocalDateTime createdAt;
}
