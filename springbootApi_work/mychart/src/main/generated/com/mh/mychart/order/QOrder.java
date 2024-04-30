package com.mh.mychart.order;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = 861972620L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrder order = new QOrder("order1");

    public final com.mh.mychart.member.QMember member;

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final ListPath<com.mh.mychart.order.orderitem.OrderItem, com.mh.mychart.order.orderitem.QOrderItem> orderItems = this.<com.mh.mychart.order.orderitem.OrderItem, com.mh.mychart.order.orderitem.QOrderItem>createList("orderItems", com.mh.mychart.order.orderitem.OrderItem.class, com.mh.mychart.order.orderitem.QOrderItem.class, PathInits.DIRECT2);

    public final StringPath orderName = createString("orderName");

    public QOrder(String variable) {
        this(Order.class, forVariable(variable), INITS);
    }

    public QOrder(Path<? extends Order> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrder(PathMetadata metadata, PathInits inits) {
        this(Order.class, metadata, inits);
    }

    public QOrder(Class<? extends Order> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.mh.mychart.member.QMember(forProperty("member")) : null;
    }

}

