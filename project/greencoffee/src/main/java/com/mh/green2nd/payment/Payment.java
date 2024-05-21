//package com.mh.green2nd.payment;
//
//import com.mh.green2nd.cart.Cart;
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Getter
//@Setter
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Builder
//@Table(name = "payment")
//public class Payment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "payment_id", nullable = false)
//    private Long paymentId;
//
//    @OneToOne
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
//
//    @Column(name = "amount")
//    private double amount;
//
//    @Column(name = "payment_type", nullable = false)
//    private String paymentType = "현금";
//
//    @Column(name = "status", nullable = false)
//    private String status;
//
//}