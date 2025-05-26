package umc.spring.domain.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.Term;
import umc.spring.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberFoodCategory extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "food_category_id")
	private FoodCategory foodCategory;

	public void setMember(Member member) {
		if(this.member !=null){
			member.getFoodCategories().remove(this);
		}
		this.member=member;
		member.getFoodCategories().add(this);
	}

}
