package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Region;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }

    public static StoreResponseDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.builder()
                .storeId(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .regionName(store.getRegion().getName())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
              .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
