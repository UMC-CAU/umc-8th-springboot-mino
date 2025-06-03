package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;

import umc.spring.domain.Member;
import umc.spring.domain.dto.MemberRequestDTO;
import umc.spring.domain.dto.MemberResponseDTO;
import umc.spring.domain.enums.Gender;

public class MemberConverter {

	public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
		return MemberResponseDTO.JoinResultDTO.builder()
			.memberId(member.getId())
			.createdAt(LocalDateTime.now())
			.build();
	}

	public static Member toMember(MemberRequestDTO.JoinDTO request){

		Gender gender = null;

		switch (request.gender()){
			case 1:
				gender = Gender.MALE;
				break;
			case 2:
				gender = Gender.FEMALE;
				break;
			case 3:
				gender = Gender.NONE;
				break;
		}

		return Member.builder()
			.address(request.address())
			.specAddress(request.specAddress())
			.gender(gender)
			.name(request.name())
			.age(request.age())
			.foodCategories(new ArrayList<>())
			.email(request.email())
			.password(request.password())
			.role(request.role())
			.build();
	}

}
