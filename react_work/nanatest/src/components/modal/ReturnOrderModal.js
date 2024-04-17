import React, { useState } from "react";
import {
  AddressBtWrap,
  AddressWrap,
} from "../../styles/address/addressconfirmstyle";
import styled from "@emotion/styled";
import {
  OrderModalBtWrap,
  OrderModalWrap,
} from "../../styles/modal/orderModalStyle";
{
  /* 반품처리 {_orders.idetails}|{_orders.productCnt}|{_orders.price} */
}
const ReturnOrderModal = ({
  closeModal,
  idetailData,
  handleReturnOrder,
  _iDetails,
}) => {
  // console.log("idetailData : ", idetailData);
  const [returncontents, setReturncontents] = useState("");
  const handleReturnChange = e => {
    setReturncontents(e.target.value);
  };
  // console.log("모달버튼idetailData", idetailData._iDetails);
  // console.log("모달버튼눌럿는데이거idetailData", idetailData);

  return (
    <OrderModalWrap>
      <div className="modal-content">
        {/* <h2>반품신청</h2> */}
        <h2>반품신청 하시겠습니까?</h2>
        <input
          type="text"
          placeholder="반품사유를 적어주세요"
          className="return-input"
          value={returncontents}
          onChange={e => handleReturnChange(e)}
        />
        <OrderModalBtWrap>
          <button
            className="modal-bt"
            onClick={() => handleReturnOrder(idetailData, returncontents)}
            style={{
              backgroundColor: "#F24747",
              color: "#fff",
              border: "none",
            }}
          >
            반품신청
          </button>
          <button
            className="modal-bt"
            style={{ background: "#ededed", color: "#868686" }}
            onClick={closeModal}
          >
            아니요
          </button>
        </OrderModalBtWrap>
      </div>
    </OrderModalWrap>
  );
};

export default ReturnOrderModal;
