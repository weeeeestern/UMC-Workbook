package umc.spring.study.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.MemberMission.MemberMission;
import umc.spring.study.domain.mapping.MemberMission.MemberMissionStatus;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
    Page<MemberMission> findAllByMemberIdAndStatus(Long memberId, MemberMissionStatus status, Pageable pageable);
}
