package umc.spring.study.converter;

import umc.spring.study.domain.Member.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.MemberMission.MemberMission;
import umc.spring.study.domain.mapping.MemberMission.MemberMissionStatus;
import umc.spring.study.web.dto.MemberMissionResponseDTO;

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
}
