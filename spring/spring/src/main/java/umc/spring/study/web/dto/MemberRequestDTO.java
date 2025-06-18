package umc.spring.study.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.study.domain.Role;
import umc.spring.study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDto{
        @NotBlank(message = "공백일 수 없습니다")
        String name;
        @NotNull(message = "널이어서는 안됩니다")
        Integer gender;
        @NotNull(message = "널이어서는 안됩니다")
        Integer age;
        @NotNull(message = "널이어서는 안됩니다")
        Integer birthYear;
        @NotNull(message = "널이어서는 안됩니다")
        Integer birthMonth;
        @NotNull(message = "널이어서는 안됩니다")
        Integer birthDay;
        @Size(min=5, max=12)
        String address;
        @Size(min=5, max=12)
        String specAddress;
        @ExistCategories // 커스텀 어노테이션
        List<Long> preferCategory;

        @Email
        String email;    // 이메일 필드 추가
        @NotBlank
        String password;    // 비밀번호 필드 추가
        @NotNull
        Role role;    // 역할 필드 추가
    }
}
