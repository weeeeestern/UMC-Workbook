package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.MemberMissionConverter;
import umc.spring.study.domain.mapping.MemberMission.MemberMission;
import umc.spring.study.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.study.web.dto.MemberMissionRequestDTO;
import umc.spring.study.web.dto.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO> challengeMission(
            @RequestBody @Valid MemberMissionRequestDTO request) {

        MemberMission result = memberMissionCommandService.challengeMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toResponseDTO(result));
    }
}
