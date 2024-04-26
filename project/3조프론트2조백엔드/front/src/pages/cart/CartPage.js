import React, { useState } from "react";
import { InfoWrap, MyWrap } from "../../styles/basic/sideWrap";
import ReviewBt from "../../components/mypage/ReviewBt";
import { useNavigate } from "react-router";
import styled from "@emotion/styled/macro";
import { Common } from "../../styles/CommonCss";
import CreateReview from "../mypage/outlet/CreateReview";
import MyReview from "../mypage/outlet/MyReview";
import PickUpCart from "./PickUpCart";
import ShippingCart from "./ShippingCart";
import { PB20, PB30 } from "../../styles/basic";
import { MarginB20, MarginB40 } from "../../styles/common/reviewProductCss";

const CartPage = () => {
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
    <div>
      <MyWrap>
        <InfoWrap>
          <PB20>장바구니</PB20>
          <MarginB20 />
          <div>
            <ReviewBt
              btName="픽업 결제"
              cartId={1}
              active={activeNavBt === 1}
              onClick={() => {
                handleBtClick(1);
              }}
            />
            <ReviewBt
              btName="배송 결제"
              cartId={2}
              active={activeNavBt === 2}
              onClick={() => handleBtClick(2)}
            />
          </div>
          <hr />
          <div className="page-content">
            {activeNavBt === 1 ? <PickUpCart /> : <ShippingCart />}
          </div>
        </InfoWrap>
      </MyWrap>
    </div>
  );
};

export default CartPage;
