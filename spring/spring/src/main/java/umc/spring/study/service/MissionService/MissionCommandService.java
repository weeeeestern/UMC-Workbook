package umc.spring.study.service.MissionService;

import umc.spring.study.domain.Mission;
import umc.spring.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMission(Long storeId, MissionRequestDTO request);
}
