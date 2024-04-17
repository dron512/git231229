import React from "react";
import {
  ProductMainDiscount,
  ProductMainDiscountTxt,
  ProductMainDiscountWrap,
} from "../../styles/cart/cartstyle";

const CartMainDis = ({ serverData, selectedItems, calculateTotalPrice }) => {
  const items = selectedItems || [];

  // calculateTotalPrice 함수에 빈 배열을 전달하여 호출
  const totalPrice = calculateTotalPrice(items);
  const formattedTotalPrice = totalPrice ? totalPrice.toLocaleString() : 0;
  // console.log("formattedTotalPrice:", formattedTotalPrice);

  return (
    <div>
      <ProductMainDiscountWrap>
        <ProductMainDiscountTxt>
          <p>총 상품금액</p>
          <p>총 배송비</p>
          <p>결제예정금액</p>
        </ProductMainDiscountTxt>
        <ProductMainDiscount>
          <p>{formattedTotalPrice}원</p>
          <p>0 원</p>
          <p> ={formattedTotalPrice} 원</p>
        </ProductMainDiscount>
      </ProductMainDiscountWrap>
    </div>
  );
};

export default CartMainDis;
