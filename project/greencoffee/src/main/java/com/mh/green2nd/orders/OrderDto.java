//package com.mh.green2nd.order;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.mh.green2nd.user.User;
//import io.swagger.v3.oas.annotations.media.Schema;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//public class OrderDto {
//    @Column(name = "orders_id", nullable = false)
//    @Schema(title = "orders_id",description = "주문 id")
//    private Long orders_id;
//
//    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
//    @Schema(title = "주문생성시간")
//    private LocalDateTime create_date = LocalDateTime.now();
//
//    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
//    @Schema(title = "주문수정시간")
//    private LocalDateTime modified_date = LocalDateTime.now();
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    private User user_id;
//
//    @Enumerated(EnumType.STRING)
//    @Schema(title = "결제완료여부")
//    private Paystate paystate;
//}
