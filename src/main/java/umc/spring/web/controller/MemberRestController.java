package umc.spring.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.domain.dto.MemberRequestDTO;
import umc.spring.domain.dto.MemberResponseDTO;
import umc.spring.global.ApiResponse;
import umc.spring.global.apipayload.code.status.SuccessStatus;
import umc.spring.service.MemberCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

	private final MemberCommandService memberCommandService;

	@PostMapping
	public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request){
		Member member=memberCommandService.joinMember(request);
		return ApiResponse.onSuccess(SuccessStatus.MEMBER_CREATE_OK, MemberConverter.toJoinResultDTO(member));
	}
}
