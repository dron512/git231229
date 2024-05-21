//package com.mh.green2nd.payment;
//
//import com.mh.green2nd.cart.Cart;
//import com.mh.green2nd.cart.CartService;
//import com.mh.green2nd.user.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/payment")
//public class PaymentController {
//
//    private final PaymentService paymentService;
//    private final CartService cartService;
//
//    @PostMapping("/create")
//    public ResponseEntity<Payment> createPayment(@RequestBody PaymentDto paymentDto, Authentication authentication) {
//        User user = (User) authentication.getPrincipal();
//        Cart cart = cartService.getCartByUser(user);
//        Payment createdPayment = paymentService.createPayment(cart, paymentDto.getPaymentType(), authentication);
//        return ResponseEntity.ok(createdPayment);
//    }
//
//    @PutMapping("/update/{paymentId}/{paymentStatus}")
//    public ResponseEntity<?> updatePaymentStatus(@PathVariable Long paymentId, @PathVariable PaymentStatus paymentStatus, Authentication authentication) {
//        User user = (User) authentication.getPrincipal();
//
//        paymentService.updatePaymentStatus(paymentId, paymentStatus); // remove authentication parameter
//
//        if (paymentStatus == PaymentStatus.결제완료 || paymentStatus == PaymentStatus.결제취소) {
//            cartService.clearCart(user);
//        }
//
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{paymentId}")
//    public ResponseEntity<?> getPaymentDetails(@PathVariable Long paymentId) {
//        Payment payment = paymentService.getPaymentById(paymentId);
//        String paymentType = payment.getPaymentType() != null ? payment.getPaymentType() : "현금";
//        return ResponseEntity.ok("Amount: " + payment.getAmount() + ", Payment Type: " + paymentType + ", Total Price: " + payment.getAmount());
//    }
//}