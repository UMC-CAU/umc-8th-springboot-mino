package umc.spring.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;

public class MemberResponseDTO {
	@Builder
	public record JoinResultDTO(
		Long memberId,
		LocalDateTime createdAt
	){}
}
