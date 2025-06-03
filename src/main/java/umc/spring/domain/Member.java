package umc.spring.domain;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.LoginType;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.Role;
import umc.spring.domain.mapping.MemberFoodCategory;
import umc.spring.domain.mapping.MemberInquiry;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MemberTerm;
import umc.spring.domain.mapping.Review;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false,length = 10)
	private String name;

	private Integer age;

	private Gender gender;

	private LocalDate birth;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
	private MemberStatus status;

	@Column(nullable = false,length = 100)
	private String address;

	@Column(nullable = false,length = 100)
	private String specAddress;

	@Column(length = 50,unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	private Boolean isCertificated;

	@ColumnDefault("0")
	private Integer point;


	@Enumerated(EnumType.STRING)
	private LoginType loginType;

	@OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
	private List<MemberInquiry> inquiries;

	@OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
	private List<MemberTerm> terms;

	@OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
	private List<Review> reviews;

	@OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
	private List<MemberMission> missions;

	@OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
	private List<MemberFoodCategory> foodCategories;

	public void encodePassword(String encode) {
		this.password = encode;
	}
}
