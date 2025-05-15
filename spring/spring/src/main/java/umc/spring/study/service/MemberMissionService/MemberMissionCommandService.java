package umc.spring.study.service.MemberMissionService;

import umc.spring.study.domain.mapping.MemberMission.MemberMission;
import umc.spring.study.web.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission challengeMission(MemberMissionRequestDTO request);
}
