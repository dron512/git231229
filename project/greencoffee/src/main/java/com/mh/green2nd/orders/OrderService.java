package com.mh.green2nd.orders;

import com.mh.green2nd.cart.Cart;
import com.mh.green2nd.cart.CartRepository;
import com.mh.green2nd.cart.cartMenu.CartMenu;
import com.mh.green2nd.cart.cartMenu.CartMenuRepository;
import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.orders.dto.OrderReqDto;
import com.mh.green2nd.orders.orderitem.OrderMenu;
import com.mh.green2nd.orders.orderitem.OrderMenuRepository;
import com.mh.green2nd.orders.orderitem.OrderMenuService;
import com.mh.green2nd.user.User;
import com.mh.green2nd.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMenuRepository orderMenuRepository;
    private final CartMenuRepository cartMenuRepository;
    private final UserRepository userRepository;
    private final OrderMenuService orderMenuService;
    private final CartRepository cartRepository;

    @Transactional
    public void createNewOrder(OrderReqDto[] orderReqDtoArray, User jwtUser) {
        // jwt 토큰안에 해당하는 유저가 없으면 에러...
        User dbUser = userRepository.findById(jwtUser.getUser_id()).orElseThrow(() -> {
            return new IllegalArgumentException("해당 유저가 없습니다.");
        });
        // order 부모
        Order order = new Order();
        // db 유저를
        order.setUser(dbUser);
        // 주문한메뉴  order 테이블추가
        int total = 0;
        for (OrderReqDto orderReqDto : orderReqDtoArray) {
            OrderMenu orderMenu = new OrderMenu();
            orderMenu.setOrder(order);

            Menu menu = cartMenuRepository.findById(
                            orderReqDto.getCartmenu_id())
                    .get().getMenu();

            orderMenu.setMenu(menu);
            orderMenu.setQuantity(orderReqDto.getQuantity());

            orderMenu.setIce(orderReqDto.getIce());
            orderMenu.setShot(orderReqDto.getShot());
            orderMenu.setCream(orderReqDto.getCream());

            double extraPrice = orderReqDto.getIce() * 200 + orderReqDto.getShot() * 500 + orderReqDto.getCream() * 500;
            total += (extraPrice + menu.getMenu_price()) * orderReqDto.getQuantity();

            orderMenu.setSubPrice((extraPrice + menu.getMenu_price()) * orderReqDto.getQuantity());
            orderMenuRepository.save(orderMenu);
        }

        order.setTotalOrderPrice(total);
        orderRepository.save(order);

        int subTotal = 0;
        for (OrderReqDto orderReqDto : orderReqDtoArray) {
            CartMenu cartMenu = cartMenuRepository.findById(orderReqDto.getCartmenu_id())
                    .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));

            subTotal = subTotal + (int) (cartMenu.getSubCartPrice());
            cartMenuRepository.deleteById(cartMenu.getCartmenu_id());
        }

        Optional<Cart> dbCart = cartRepository.findById(1L);
        if(dbCart.isPresent()){
            Cart cart = dbCart.get();
            cart.setTotalCartPrice(cart.getTotalCartPrice() - subTotal);
            cartRepository.save(cart);
        }
    }

    // 주문내역 보여주기
    @Transactional
    public List<Order> orderList(User jwtUser) {
        User dbUser = userRepository.findById(jwtUser.getUser_id()).orElseThrow(() -> {
            return new IllegalArgumentException("해당 유저가 없습니다.");
        });
        return orderRepository.findByUser(dbUser);
    }

    public double calculateTotalOrderPrice(Cart cart) {
        double totalOrderPrice = 0.0;
//        for (OrderMenu orderMenu : cart.getOrderMenusList()) {
//            double subOrderPrice = orderMenuService.calculateSubOrderPrice(orderMenu);
//            totalOrderPrice += subOrderPrice;
//        }
        return totalOrderPrice;
    }

//    private Order convertToEntity(OrderDto orderDto) {
//        // 여기에서 OrdersDto를 Orders 엔티티로 변환하는 코드 작성
//    }
//
//    private OrderDto convertToDto(com.mh.green2nd.order.Order order) {
//        // 여기에서 Orders 엔티티를 OrdersDto로 변환하는 코드 작성
//    }
//
//
//    public static Optional<OrderDto> neworder(Long ordersId) {
//    }
}

