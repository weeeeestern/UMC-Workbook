package umc.spring.study.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.mapping.MemberMission.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}
