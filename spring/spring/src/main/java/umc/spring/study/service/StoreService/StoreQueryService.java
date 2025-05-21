package umc.spring.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    public boolean existsById(Long id);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
