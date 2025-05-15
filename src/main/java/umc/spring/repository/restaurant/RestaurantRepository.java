package umc.spring.repository.restaurant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import umc.spring.domain.Member;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.mapping.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> ,RestaurantRepositoryCustom{
}
