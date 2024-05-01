package com.mh.mychart.order;

import com.mh.mychart.item.Item;
import com.mh.mychart.item.ItemRepository;
import com.mh.mychart.item.QItem;
import com.mh.mychart.member.Member;
import com.mh.mychart.member.MemberRepository;
import com.mh.mychart.member.QMember;
import com.mh.mychart.order.orderitem.OrderItem;
import com.mh.mychart.order.orderitem.OrderItemRepository;
import com.mh.mychart.order.orderitem.QOrderItem;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContexts;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Persistent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

//    @PersistenceContext
//    EntityManager entityManager;

    @Autowired
    private JPAQueryFactory queryFactory;

    @BeforeEach
    public void setUp(){
    }

    @Test
    @DisplayName("주문생성")
//    @Transactional
    public void newOrder(){
//        Optional<Member> member = memberRepository.findById(1l);
//        if(member.isEmpty()) {
//            // member 1개 저장
//            memberRepository.save(
//                    Member.builder()
//                            .email("aaa@naver.com")
//                            .nickname("aaa")
//                            .build()
//            );
//        }
//        for (int i = 0; i < 10; i++) {
//            itemRepository.save(
//                    Item.builder()
//                            .name("item"+i)
//                            .price(1000+i*100)
//                            .build()
//            );
//        }

        List<OrderItem> list = new ArrayList<>();

        Order order = Order.builder()
                .member(memberRepository.findById(1l).get())
                .orderName("오전주문")
                .orderItems(list)
                .build();

        for(int i= 1; i<4 ; i++) {
            Item item = itemRepository.findById((long) i).get();

            OrderItem orderItem = OrderItem.builder()
                    .item(item)
                    .order(order)
                    .orderItemName(item.getName())
                    .orderItemPrice(item.getPrice() * 10)
                    .orderItemQuantity(10)
                    .build();
            list.add(orderItem);
        }

        orderRepository.save(order);

//        entityManager.clear();


//        orderRepository.deleteAll();
//        itemRepository.deleteAll();
//        memberRepository.deleteAll();

    }

    @Test
    @DisplayName("주문Item삭제")
    public void deleteItems(){

        Optional<Order> order = orderRepository.findById(8l);

        order.ifPresent(ord->{
            orderRepository.delete(ord);
        });

    }


    @Test
    @DisplayName("주문리스트select")
    public void selectOrder(){
        QOrder qOrder = QOrder.order;
        QOrderItem qOrderItem = QOrderItem.orderItem;
        QItem qItem = QItem.item;
        QMember qMember = QMember.member;

        List<Order> orderList = queryFactory.selectFrom(qOrder)
                .leftJoin(qMember)
                .on(qMember.id.eq(qOrder.member.id))
                .leftJoin(qOrderItem)
                .on(qOrder.orderId.eq(qOrderItem.order.orderId))
                .leftJoin(qItem)
                .on(qOrderItem.item.id.eq(qItem.id))
                .where(qMember.id.eq(1l))
                .offset(0)
                .limit(3)
                .orderBy(qOrder.orderId.desc())
                .fetch();


        orderList.forEach(
                order -> {
                    System.out.println(order.getMember());
                    System.out.println(order.getOrderId());
                    System.out.println(order.getOrderName());
                    List<OrderItem> list = order.getOrderItems();
                    list.forEach(item->{
                        System.out.println(item.getOrderItemName());
                        System.out.println(item.getOrderItemPrice());
                    });
                }
        );
    }

    @Test
    @DisplayName("주문하나select")
    public void selectOneOrder(){
        Order order = orderRepository.findById(8l).orElse(null);

        System.out.println(order.getOrderItems().size());
        System.out.println(order.getOrderName());
        System.out.println(order.getMember());

        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem.getOrderItemName());
            System.out.println(orderItem.getOrderItemPrice());
            System.out.println(orderItem.getOrderItemQuantity());
        }
    }

    @AfterEach
    public void tearDown(){

    }
}















