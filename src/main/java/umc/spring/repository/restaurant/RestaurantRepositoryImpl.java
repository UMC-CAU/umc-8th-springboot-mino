package umc.spring.repository.restaurant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.mapping.QRestaurant;
import umc.spring.domain.mapping.Restaurant;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {
	private final JPAQueryFactory jpaQueryFactory;
	private final QRestaurant restaurant=QRestaurant.restaurant;

	@Override
	public List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (name!=null){
			predicate.and(restaurant.name.eq(name));
		}

		if(score!=null){
			//4.0이상인경우
			predicate.and(restaurant.score.goe(4.0f));
		}

		return jpaQueryFactory
			.selectFrom(restaurant)
			.where(predicate)
			.fetch();
	}
}
