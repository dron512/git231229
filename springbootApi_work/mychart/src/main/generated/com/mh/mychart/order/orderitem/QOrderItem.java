package com.mh.mychart.order.orderitem;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderItem is a Querydsl query type for OrderItem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderItem extends EntityPathBase<OrderItem> {

    private static final long serialVersionUID = 226135538L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderItem orderItem = new QOrderItem("orderItem");

    public final com.mh.mychart.item.QItem item;

    public final com.mh.mychart.order.QOrder order;

    public final NumberPath<Long> orderItemId = createNumber("orderItemId", Long.class);

    public final StringPath orderItemName = createString("orderItemName");

    public final NumberPath<Integer> orderItemPrice = createNumber("orderItemPrice", Integer.class);

    public final NumberPath<Integer> orderItemQuantity = createNumber("orderItemQuantity", Integer.class);

    public QOrderItem(String variable) {
        this(OrderItem.class, forVariable(variable), INITS);
    }

    public QOrderItem(Path<? extends OrderItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderItem(PathMetadata metadata, PathInits inits) {
        this(OrderItem.class, metadata, inits);
    }

    public QOrderItem(Class<? extends OrderItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.item = inits.isInitialized("item") ? new com.mh.mychart.item.QItem(forProperty("item")) : null;
        this.order = inits.isInitialized("order") ? new com.mh.mychart.order.QOrder(forProperty("order"), inits.get("order")) : null;
    }

}

