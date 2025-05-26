package umc.spring.service;

import umc.spring.domain.Member;
import umc.spring.domain.dto.MemberRequestDTO;

public interface MemberCommandService {
	public Member joinMember(MemberRequestDTO.JoinDTO dto);
}
