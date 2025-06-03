package umc.spring.domain.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

public class MemberRequestDTO {
	@Builder
	public record JoinDTO(
		String name,
		Integer gender,
		String email,
		String password,
		Integer birthYear,
		Integer birthMonth,
		Integer birthDay,
		String address,
		String specAddress,
		Integer age,
		@ExistCategories
		List<Long>preferCategory,
		@NotNull
		Role role
	){}
}
