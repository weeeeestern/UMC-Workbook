package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Member.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.ReviewImage;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.ReviewRequestDTO;
import umc.spring.study.web.dto.ReviewResponseDTO;

import java.util.List;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO request, Member member, Store store) {
        return Review.builder()
                .member(member)
                .store(store)
                .score(request.getRating())
                .build();
    }

    public static ReviewResponseDTO.MyReviewPreviewDTO toMyReviewPreviewDTO(Review review) {
        return ReviewResponseDTO.MyReviewPreviewDTO.builder()
                .name(review.getMember().getName())
                .rating(review.getScore())
                .content(review.getBody())
                .createdAt(review.getCreatedAt().toLocalDate())
                .imageUrls(review.getReviewImageList().stream()
                        .map(ReviewImage::getImageUrl)
                        .toList())
                .build();
    }

    public static ReviewResponseDTO.MyReviewListDTO toMyReviewListDTO(Page<Review> reviewPage) {
        List<ReviewResponseDTO.MyReviewPreviewDTO> dtoList = reviewPage.getContent().stream()
                .map(ReviewConverter::toMyReviewPreviewDTO)
                .toList();

        return ReviewResponseDTO.MyReviewListDTO.builder()
                .reviewList(dtoList)
                .listSize(dtoList.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }

}
