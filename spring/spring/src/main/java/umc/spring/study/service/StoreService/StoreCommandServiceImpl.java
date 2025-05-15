package umc.spring.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.RegionHandler;
import umc.spring.study.converter.StoreConverter;
import umc.spring.study.domain.Region;
import umc.spring.study.domain.Store;
import umc.spring.study.repository.RegionRepository.RegionRepository;
import umc.spring.study.repository.StoreRepository.StoreRepository;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Store addStore(Long regionId, StoreRequestDTO request) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        Store store = StoreConverter.toStore(request, region);

        return storeRepository.save(store);
    }
}
