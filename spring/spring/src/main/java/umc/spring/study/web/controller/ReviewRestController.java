package umc.spring.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.Review;
import umc.spring.study.service.ReviewService.ReviewCommandService;
import umc.spring.study.service.ReviewService.ReviewQueryService;
import umc.spring.study.service.ReviewService.ReviewQueryServiceImpl;
import umc.spring.study.validation.annotation.StoreExists;
import umc.spring.study.validation.annotation.ValidPage;
import umc.spring.study.web.dto.ReviewRequestDTO;
import umc.spring.study.web.dto.ReviewResponseDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

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