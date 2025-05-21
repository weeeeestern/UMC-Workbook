package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class ReviewResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewPreviewDTO {
        String name;
        Float rating;
        String content;
        LocalDate createdAt;
        List<String> imageUrls; // 0~3개 가능
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewListDTO {
        String storeName;        // 가게명
        Integer reviewCount;     // 전체 리뷰 개수
        List<MyReviewPreviewDTO> reviewList;
        Integer listSize;        // 현재 페이지 사이즈
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
