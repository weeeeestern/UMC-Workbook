package umc.spring.study.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.MemberHandler;
import umc.spring.study.apiPayload.exception.handler.MissionHandler;
import umc.spring.study.apiPayload.exception.handler.StoreHandler;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.Member.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.ReviewImage;
import umc.spring.study.domain.Store;
import umc.spring.study.repository.MemberRepository.MemberRepository;
import umc.spring.study.repository.MissionRepository.MissionRepository;
import umc.spring.study.repository.ReviewImageRepository.ReviewImageRepository;
import umc.spring.study.repository.ReviewRepository.ReviewRepository;
import umc.spring.study.repository.StoreRepository.StoreRepository;
import umc.spring.study.web.dto.ReviewRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final ReviewImageRepository reviewImageRepository;

    public Review createReview(ReviewRequestDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = null;
        if (request.getMissionId() != null) {
            mission = missionRepository.findById(request.getMissionId())
                    .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        }

        Review review = ReviewConverter.toReview(request, member, store);
        Review savedReview = reviewRepository.save(review);

        if (request.getImages() != null) {
            List<ReviewImage> imageEntities = request.getImages().stream()
                    .map(file -> ReviewImage.builder()
                            .review(savedReview)
                            .imageUrl(file.getOriginalFilename()) // 파일명만 저장
                            .build())
                    .toList();

            reviewImageRepository.saveAll(imageEntities);
        }

        return savedReview;
    }
}


