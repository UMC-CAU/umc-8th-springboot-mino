package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberFoodCategory is a Querydsl query type for MemberFoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberFoodCategory extends EntityPathBase<MemberFoodCategory> {

    private static final long serialVersionUID = 1154798082L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberFoodCategory memberFoodCategory = new QMemberFoodCategory("memberFoodCategory");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberFoodCategory(String variable) {
        this(MemberFoodCategory.class, forVariable(variable), INITS);
    }

    public QMemberFoodCategory(Path<? extends MemberFoodCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberFoodCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberFoodCategory(PathMetadata metadata, PathInits inits) {
        this(MemberFoodCategory.class, metadata, inits);
    }

    public QMemberFoodCategory(Class<? extends MemberFoodCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.spring.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
    }

}

