package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.domain.Review;
import umc.spring.study.service.ReviewService.ReviewCommandService;
import umc.spring.study.web.dto.ReviewRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<String> createReview(@ModelAttribute @Valid ReviewRequestDTO request) {
        Review review = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess("리뷰 등록이 완료되었습니다.");
    }
}