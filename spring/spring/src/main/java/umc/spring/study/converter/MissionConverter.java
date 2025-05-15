package umc.spring.study.converter;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.MissionRequestDTO;
import umc.spring.study.web.dto.MissionResponseDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO dto, Store store) {
        return Mission.builder()
                .reward(dto.getReward())
                .missionSpec(dto.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDTO toResponseDTO(Mission mission) {
        return MissionResponseDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .build();
    }
}
