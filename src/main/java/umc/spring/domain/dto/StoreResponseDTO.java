package umc.spring.domain.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;

public class StoreResponseDTO {
	@Builder
	public record ReviewPreViewListDTO(
		List<ReviewPreviewDTO> reviewList,
		Integer listSize,
		Integer totalPage,
		Long totalElements,
		Boolean isFirst,
		Boolean isLast
	){}

	@Builder
	public record ReviewPreviewDTO(
		String ownerNickname,
		Float score,
		String body,
		LocalDate createdAt
	){}
}
