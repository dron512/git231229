import React, { useState } from "react";
import InfoTitle from "../../components/titleItems/InfoTitle";
import OrderView from "./OrderView";
import ReturnView from "./ReturnView";
import styled from "@emotion/styled";
import ReturnOrderModal from "../../components/modal/ReturnOrderModal";

const OrderListPage = () => {
  const OrderPageStyle = styled.div`
    max-width: 1280px;
    margin: 0 auto;

    .order-button {
      border-bottom: solid 1px#868686;
    }

    .order-button button {
      width: 150px;
      height: 40px;
      cursor: pointer;
      border: 1px solid transparent;
      background-color: #fff;

      /* background-color: #fff; */
    }
    .active {
      border: 1px solid #666666;
      background-color: #fff;
      /* color: #fff; */
    }
    .button:hover,
    button.active {
      border: 1px solid #666;
    }
  `;
  const infoText = "ORDER-LIST";

  // 주문/취소 버튼
  const [orderSelectButton, setSelectOrderButton] = useState("orderView");

  const handChangeOrder = buttonType => {
    setSelectOrderButton(buttonType);
  };

  return (
    <OrderPageStyle>
      <div className="inner-header">
        <InfoTitle infoText={infoText} />
        <div className="order-button">
          <button
            className={`${orderSelectButton === "orderView" ? "active" : ""}`}
            onClick={() => {
              handChangeOrder("orderView");
            }}
          >
            주문내역조회
          </button>
          <button
            className={`${orderSelectButton === "returnView" ? "active" : ""}`}
            onClick={() => {
              handChangeOrder("returnView");
            }}
          >
            취소/반품조회
          </button>
        </div>
        <div className="page-content">
          {orderSelectButton === "orderView" ? <OrderView /> : <ReturnView />}
        </div>
      </div>
    </OrderPageStyle>
  );
};

export default OrderListPage;
