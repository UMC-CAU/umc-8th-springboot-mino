package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlarmLog is a Querydsl query type for AlarmLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlarmLog extends EntityPathBase<AlarmLog> {

    private static final long serialVersionUID = -1013633793L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlarmLog alarmLog = new QAlarmLog("alarmLog");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath message = createString("message");

    public final QRestaurant restaurant;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAlarmLog(String variable) {
        this(AlarmLog.class, forVariable(variable), INITS);
    }

    public QAlarmLog(Path<? extends AlarmLog> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlarmLog(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlarmLog(PathMetadata metadata, PathInits inits) {
        this(AlarmLog.class, metadata, inits);
    }

    public QAlarmLog(Class<? extends AlarmLog> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

