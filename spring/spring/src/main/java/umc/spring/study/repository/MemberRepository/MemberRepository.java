package umc.spring.study.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Member.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
