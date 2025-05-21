package umc.spring.study.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.MemberMission.MemberMission;
import umc.spring.study.domain.mapping.MemberMission.MemberMissionStatus;

public interface MemberMissionQueryService {
    Page<MemberMission> getMyMissionsByMemberIAndStatus(Long memberId, MemberMissionStatus status, int pageIndex);
}
