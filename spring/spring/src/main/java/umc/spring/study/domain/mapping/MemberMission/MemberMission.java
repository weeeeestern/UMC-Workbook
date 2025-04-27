package umc.spring.study.domain.mapping.MemberMission;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.study.domain.Member.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mission_id")
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private MemberMissionStatus status;

}
