package umc.spring.domain.mapping;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.State;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.InquiryStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 20)
	private String name;

	@Column(nullable = false, length = 100)
	private String address;

	private Integer score;

	private Float latitude;

	private Float longitude;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "state_id")
	private State state;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "food_category_id")
	private FoodCategory foodCategory;

	@OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
	private List<Review> reviews;

	@OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
	private List<AlarmLog> alarmLogs;

	@OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
	private List<Mission> missions;
}
