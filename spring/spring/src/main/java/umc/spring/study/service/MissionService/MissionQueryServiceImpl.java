package umc.spring.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.Mission;
import umc.spring.study.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> getMissionsByStoreId(Long storeId, int pageIndex) {
        Pageable pageable = PageRequest.of(pageIndex, 10, Sort.by("createdAt").descending());
        return missionRepository.findAllByStoreId(storeId, pageable);
    }
}
