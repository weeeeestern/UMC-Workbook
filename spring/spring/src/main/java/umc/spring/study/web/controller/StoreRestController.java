package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.StoreConverter;
import umc.spring.study.domain.Store;
import umc.spring.study.service.StoreService.StoreCommandService;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping
    public ApiResponse<StoreResponseDTO> addStore(
            @RequestParam("region") Long regionId,
            @RequestBody @Valid StoreRequestDTO request) {

        Store store = storeCommandService.addStore(regionId, request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }
}
