package umc.spring.study.validation.validator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.study.validation.annotation.NotChallenging;

@Component
@RequiredArgsConstructor
public class NotChallengingValidator implements ConstraintValidator<NotChallenging, Long> {

    private final HttpServletRequest request;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        try {
            String memberIdStr = request.getParameter("memberId");
            if (memberIdStr == null) return true; // memberId 없음 → 건너뜀
            Long memberId = Long.parseLong(memberIdStr);

            return !memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);

        } catch (Exception e) {
            return true; // 예외 발생 시 일단 true 처리
        }
    }
}

