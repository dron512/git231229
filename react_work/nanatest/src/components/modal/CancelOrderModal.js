import React from "react";
import { AddressWrap } from "../../styles/address/addressconfirmstyle";
import {
  CancelModalBtWrap,
  OrderModalBtWrap,
  OrderModalWrap,
  RuturnModalBtWrap,
} from "../../styles/modal/orderModalStyle";
{
  /* 반품처리 {_orders.idetails}|{_orders.productCnt}|{_orders.price} */
}
const CancelOrderModal = ({ closeModal, handleCancelOrder, orderData }) => {
  // console.log("모달버튼눌럿는데이거 iorder임", orderData._iOrder);

  return (
    <OrderModalWrap>
      <div className="modal-content">
        <h2>주문취소 하시겠습니까?</h2>
        <CancelModalBtWrap>
          <button
            className="modal-bt"
            onClick={() => handleCancelOrder(orderData)}
            style={{
              backgroundColor: "#F24747",
              color: "#fff",
              border: "none",
            }}
          >
            주문취소
          </button>
          <button
            className="modal-bt"
            style={{ background: "#ededed", color: "#868686" }}
            onClick={closeModal}
          >
            아니요
          </button>
        </CancelModalBtWrap>
      </div>
    </OrderModalWrap>
  );
};

export default CancelOrderModal;
