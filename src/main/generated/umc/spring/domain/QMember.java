package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1366956614L;

    public static final QMember member = new QMember("member1");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final ListPath<umc.spring.domain.mapping.MemberFoodCategory, umc.spring.domain.mapping.QMemberFoodCategory> foodCategories = this.<umc.spring.domain.mapping.MemberFoodCategory, umc.spring.domain.mapping.QMemberFoodCategory>createList("foodCategories", umc.spring.domain.mapping.MemberFoodCategory.class, umc.spring.domain.mapping.QMemberFoodCategory.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.domain.mapping.MemberInquiry, umc.spring.domain.mapping.QMemberInquiry> inquiries = this.<umc.spring.domain.mapping.MemberInquiry, umc.spring.domain.mapping.QMemberInquiry>createList("inquiries", umc.spring.domain.mapping.MemberInquiry.class, umc.spring.domain.mapping.QMemberInquiry.class, PathInits.DIRECT2);

    public final BooleanPath isCertificated = createBoolean("isCertificated");

    public final EnumPath<umc.spring.domain.enums.LoginType> loginType = createEnum("loginType", umc.spring.domain.enums.LoginType.class);

    public final ListPath<umc.spring.domain.mapping.MemberMission, umc.spring.domain.mapping.QMemberMission> missions = this.<umc.spring.domain.mapping.MemberMission, umc.spring.domain.mapping.QMemberMission>createList("missions", umc.spring.domain.mapping.MemberMission.class, umc.spring.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<umc.spring.domain.mapping.Review, umc.spring.domain.mapping.QReview> reviews = this.<umc.spring.domain.mapping.Review, umc.spring.domain.mapping.QReview>createList("reviews", umc.spring.domain.mapping.Review.class, umc.spring.domain.mapping.QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.Role> role = createEnum("role", umc.spring.domain.enums.Role.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc.spring.domain.enums.MemberStatus> status = createEnum("status", umc.spring.domain.enums.MemberStatus.class);

    public final ListPath<umc.spring.domain.mapping.MemberTerm, umc.spring.domain.mapping.QMemberTerm> terms = this.<umc.spring.domain.mapping.MemberTerm, umc.spring.domain.mapping.QMemberTerm>createList("terms", umc.spring.domain.mapping.MemberTerm.class, umc.spring.domain.mapping.QMemberTerm.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

