//package com.mh.green2nd.payment;
//
//import com.mh.green2nd.cart.Cart;
//import com.mh.green2nd.cart.CartService;
//import com.mh.green2nd.user.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class PaymentService {
//
//    private final PaymentRepository paymentRepository;
//    private final CartService cartService;
//
//    public Payment createPayment(Cart cart, String paymentType, Authentication authentication) {
//        User user = (User) authentication.getPrincipal();
//        double amount = cartService.calculateTotalPrice(cart);
//
//        Payment payment = new Payment();
//        payment.setCart(cart);
//        payment.setAmount(amount);
//        payment.setPaymentType(paymentType);
//        payment.setStatus(PaymentStatus.결제대기중.name());
//        return paymentRepository.save(payment);
//    }
//
//    public Payment getPaymentById(Long paymentId) {
//        return paymentRepository.findById(paymentId)
//                .orElseThrow(() -> new IllegalArgumentException("Payment not found with id: " + paymentId));
//    }
//
//    public void updatePaymentStatus(Long paymentId, PaymentStatus paymentStatus) {
//        Payment payment = getPaymentById(paymentId);
//        payment.setStatus(paymentStatus.name());
//        paymentRepository.save(payment);
//    }
//}