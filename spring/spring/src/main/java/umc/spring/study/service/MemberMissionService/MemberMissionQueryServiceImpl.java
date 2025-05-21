package umc.spring.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.MemberMission.MemberMission;
import umc.spring.study.domain.mapping.MemberMission.MemberMissionStatus;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.study.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMission> getMyMissionsByMemberIAndStatus(Long memberId, MemberMissionStatus status,int pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex, 10, Sort.by("createdAt").descending());
        return memberMissionRepository.findAllByMemberIdAndStatus(memberId, MemberMissionStatus.CHALLENGING,pageable);
    }
}
