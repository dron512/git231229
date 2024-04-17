import React from "react";
import { ProductSubDiscount } from "../../styles/cart/cartstyle";

const CartSubDis = ({ serverData, selectedItems, calculateTotalPrice }) => {
  // selectedItems를 직접 사용
  const totalPrice = calculateTotalPrice(selectedItems);
  const formattedTotalPrice = totalPrice ? totalPrice.toLocaleString() : 0;

  return (
    <div>
      <ProductSubDiscount>
        <div>
          <p>[기본배송]</p>
        </div>
        <div>
          <p>
            상품구매금액: {formattedTotalPrice} + 배송비 0 (무료) = 합계:{" "}
            {formattedTotalPrice}
          </p>
        </div>
      </ProductSubDiscount>
    </div>
  );
};

export default CartSubDis;
