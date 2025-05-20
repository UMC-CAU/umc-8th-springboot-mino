package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberInquiry is a Querydsl query type for MemberInquiry
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberInquiry extends EntityPathBase<MemberInquiry> {

    private static final long serialVersionUID = -1445876863L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberInquiry memberInquiry = new QMemberInquiry("memberInquiry");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    public final EnumPath<umc.spring.domain.enums.InquiryStatus> status = createEnum("status", umc.spring.domain.enums.InquiryStatus.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberInquiry(String variable) {
        this(MemberInquiry.class, forVariable(variable), INITS);
    }

    public QMemberInquiry(Path<? extends MemberInquiry> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberInquiry(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberInquiry(PathMetadata metadata, PathInits inits) {
        this(MemberInquiry.class, metadata, inits);
    }

    public QMemberInquiry(Class<? extends MemberInquiry> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
    }

}

