package umc.spring.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import umc.spring.study.validation.annotation.StoreExists;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReviewRequestDTO {
    @NotNull
    private Long memberId;

    @StoreExists  // 커스텀 어노테이션
    private Long storeId;

    private Long missionId; // optional

    @NotNull
    private Float rating;

    @NotBlank
    private String content;

    private List<MultipartFile> images; // 0~3개
}