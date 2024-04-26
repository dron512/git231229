import React, { useState } from "react";
import { InfoWrap, MyWrap } from "../../styles/basic/sideWrap";
import ReviewBt from "../../components/mypage/ReviewBt";
import styled from "@emotion/styled/macro";
import { Common } from "../../styles/CommonCss";

import { PB20, PB30 } from "../../styles/basic";
import {
  MarginB10,
  MarginB20,
  MarginB30,
  MarginB40,
} from "../../styles/common/reviewProductCss";
import OrderPickPage from "./OrderPickPage";
import OrderShipPage from "./OrderShipPage";

const OrderPage = () => {
  const [activeNavBt, setActiveNavBt] = useState(1);
  const handleBtClick = cartId => {
    setActiveNavBt(cartId);
    console.log("선택된 카트버튼", cartId);
  };

  const InfoWrap = styled.div`
    width: 100%;
    position: relative;
    hr {
      background-color: ${Common.color.b900};
      height: 3px;
      /* margin-bottom: 20px; */
    }
  `;
  return (
    <InfoWrap>
      <MarginB10 />
      <PB20>주문배송조회</PB20>
      <MarginB20 />
      <div>
        <ReviewBt
          btName="픽업조회"
          reBtId={1}
          active={activeNavBt === 1}
          onClick={() => {
            handleBtClick(1);
          }}
        />
        <ReviewBt
          btName="배송조회"
          reBtId={2}
          active={activeNavBt === 2}
          onClick={() => handleBtClick(2)}
        />
      </div>
      <hr />
      <div className="page-content">
        {activeNavBt === 1 ? <OrderPickPage /> : <OrderShipPage />}
      </div>
    </InfoWrap>
  );
};

export default OrderPage;
