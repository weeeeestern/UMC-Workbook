package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Member.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.MemberMission.MemberMission;
import umc.spring.study.domain.mapping.MemberMission.MemberMissionStatus;
import umc.spring.study.web.dto.MemberMissionResponseDTO;
import umc.spring.study.web.dto.MissionResponseDTO;

import java.util.List;

public class MemberMissionConverter {

    public static MemberMission toEntity(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MemberMissionStatus.CHALLENGING)
                .build();
    }

    public static MemberMissionResponseDTO toResponseDTO(MemberMission entity) {
        return MemberMissionResponseDTO.builder()
                .memberMissionId(entity.getId())
                .memberId(entity.getMember().getId())
                .missionId(entity.getMission().getId())
                .status(entity.getStatus().name())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewDTO toMissionPreviewDTO(MemberMission mm) {
        Mission mission = mm.getMission();

        return MissionResponseDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .createdAt(mm.getCreatedAt())
                .build();
    }

    public static MissionResponseDTO.MissionListDTO toMissionListDTO(Page<MemberMission> page) {
        List<MissionResponseDTO.MissionPreviewDTO> dtoList = page.getContent().stream()
                .map(MemberMissionConverter::toMissionPreviewDTO)
                .toList();

        return MissionResponseDTO.MissionListDTO.builder()
                .missionList(dtoList)
                .listSize(dtoList.size())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();
    }


}
