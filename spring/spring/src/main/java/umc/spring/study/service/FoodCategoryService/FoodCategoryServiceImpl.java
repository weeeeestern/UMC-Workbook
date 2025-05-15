package umc.spring.study.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.repository.FoodCategoryRepository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean existAllById(List<Long> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }
}
