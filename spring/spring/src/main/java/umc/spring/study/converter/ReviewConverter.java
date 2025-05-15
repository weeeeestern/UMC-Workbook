package umc.spring.study.converter;

import umc.spring.study.domain.Member.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.ReviewRequestDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO request, Member member, Store store) {
        return Review.builder()
                .member(member)
                .store(store)
                .score(request.getRating())
                .build();
    }
}
