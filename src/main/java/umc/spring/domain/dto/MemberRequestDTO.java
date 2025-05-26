package umc.spring.domain.dto;

import java.util.List;

import lombok.Builder;
import umc.spring.validation.annotation.ExistCategories;

public class MemberRequestDTO {
	@Builder
	public record JoinDTO(
		String name,
		Integer gender,
		Integer birthYear,
		Integer birthMonth,
		Integer birthDay,
		String address,
		String specAddress,
		Integer age,
		@ExistCategories
		List<Long>preferCategory
	){}
}
