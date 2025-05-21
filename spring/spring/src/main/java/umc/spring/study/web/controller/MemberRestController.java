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
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.MemberConverter;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.Member.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.service.MemberService.MemberCommandService;
import umc.spring.study.service.ReviewService.ReviewQueryService;
import umc.spring.study.validation.annotation.ValidPage;
import umc.spring.study.web.dto.MemberRequestDTO;
import umc.spring.study.web.dto.MemberResponseDTO;
import umc.spring.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회",
            description = "로그인한 사용자가 작성한 리뷰 목록을 1페이지부터 조회합니다. query string으로 page=1 이상 값을 줘야 합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 page 번호", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "page", description = "1 이상인 페이지 번호 (쿼리 스트링)")
    })
    public ApiResponse<ReviewResponseDTO.MyReviewListDTO> getMyReviews(
            @PathVariable Long memberId,
            @ValidPage @RequestParam("page") Integer page) {

        Page<Review> reviewPage = reviewQueryService.getMyReviews(memberId, page - 1); // 0-based index 처리
        return ApiResponse.onSuccess(ReviewConverter.toMyReviewListDTO(reviewPage));
    }
}
