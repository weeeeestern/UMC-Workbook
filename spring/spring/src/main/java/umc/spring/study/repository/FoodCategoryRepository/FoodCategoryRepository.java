package umc.spring.study.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
