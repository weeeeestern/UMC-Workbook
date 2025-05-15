package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponseDTO {
    Long storeId;
    String name;
    String address;
    String regionName;
    Float score;
    LocalDateTime createdAt;
}
