package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.dto.MemberRequestDTO;
import umc.spring.domain.dto.MemberResponseDTO;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.MemberFoodCategory;

public class MemberPreferConverter {

	public static List<MemberFoodCategory> toMemberFoodCategoryList(List<FoodCategory> foodCategorys) {
		return foodCategorys.stream()
			.map(foodCategory ->
				MemberFoodCategory.builder()
					.foodCategory(foodCategory)
					.build())
			.toList();
	}
	
}
