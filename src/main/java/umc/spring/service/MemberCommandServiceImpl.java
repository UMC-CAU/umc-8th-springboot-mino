package umc.spring.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.dto.MemberRequestDTO;
import umc.spring.domain.mapping.MemberFoodCategory;
import umc.spring.global.FoodCategoryHandler;
import umc.spring.global.apipayload.code.status.ErrorStatus;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.member.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandServiceImpl implements MemberCommandService{

	private final PasswordEncoder passwordEncoder;

	private final MemberRepository memberRepository;
	private final FoodCategoryRepository foodCategoryRepository;

	@Override
	public Member joinMember(MemberRequestDTO.JoinDTO request) {
		Member joinMember= MemberConverter.toMember(request);

		joinMember.encodePassword(passwordEncoder.encode(request.password()));
		List<FoodCategory> foodCategories=request.preferCategory().stream()
			.map(category->{
				return foodCategoryRepository.findById(category).orElseThrow(()-> new FoodCategoryHandler(
					ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
			}).toList();
		List<MemberFoodCategory> memberFoodCategories= MemberPreferConverter.toMemberFoodCategoryList(foodCategories);
		memberFoodCategories.forEach(memberFoodCategory -> {memberFoodCategory.setMember(joinMember);});
		return memberRepository.save(joinMember);
	}
}
