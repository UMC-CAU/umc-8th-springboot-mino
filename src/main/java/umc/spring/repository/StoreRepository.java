package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import umc.spring.domain.mapping.Restaurant;

@Repository
public interface StoreRepository extends JpaRepository<Restaurant,Long> {
}
