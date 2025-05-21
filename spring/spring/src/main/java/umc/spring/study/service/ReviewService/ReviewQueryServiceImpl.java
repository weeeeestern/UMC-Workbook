package umc.spring.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.Review;
import umc.spring.study.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getMyReviews(Long memberId, int pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex, 10, Sort.by("createdAt").descending());
        return reviewRepository.findAllByMemberId(memberId, pageable);
    }
}
