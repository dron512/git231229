import React, { useState } from "react";
import { Common } from "../../styles/CommonCss";
import { Button, Flex, Form, Input, Rate } from "antd";
import { BasicBtR } from "../../styles/basic/basicBt";
import { HeartOutlined } from "@ant-design/icons";
import { PB20 } from "../../styles/basic";
import { Map, MapMarker } from "react-kakao-maps-sdk";
import MapPlaceInfo from "./MapPlaceInfo";
import { dummyData } from "../../mock/PlaceData";
import {
  CloseBt,
  MapModalWrap,
  MapWrap,
  Place,
  RvModalStyle,
} from "../../styles/detail/mapModalWrapCss";
import styled from "@emotion/styled/macro";
import { BigButton, MarginB40 } from "../../styles/common/reviewProductCss";
import { useNavigate } from "react-router";
const { TextArea } = Input;

export const CartModal = ({ onClose }) => {
  const navigate = useNavigate();
  const onChange = e => {
    console.log("Change:", e.target.value);
  };
  const [selectedIndex, setSelectedIndex] = useState(null);

  const handlePlaceClick = index => {
    setSelectedIndex(index);
  };
  const CartModalStyle = styled.div`
    position: fixed;
    display: flex;
    align-items: center;
    justify-content: center;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    /* background: rgba(0, 0, 0, 0.7); */
    z-index: 999;
  `;
  const CartModalWrap = styled.div`
    position: relative;
    min-width: 350px;
    height: 250px;
    background-color: ${Common.color.p100};
    padding: 20px;
    margin: 0 auto;
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
  `;
  const CartModalinfo = styled.div`
    width: 100%;
    /* background-color: aquamarine; */
    position: relative;
    /* display: flex; */
    text-align: center;
    justify-content: center;
    margin: 30px 0 20px 0;
  `;

  return (
    <CartModalStyle>
      <CartModalWrap>
        <div style={{ display: "flex", justifyContent: "end" }}>
          <CloseBt onClick={onClose}>
            <img src={process.env.PUBLIC_URL + "/images/close2.svg"}></img>
          </CloseBt>
        </div>
        <CartModalinfo>
          <PB20>장바구니에 상품이 담겼습니다.</PB20>
          <PB20>바로 가시겠습니까?</PB20>
          <MarginB40 />
          <BigButton
            style={{
              background: `${Common.color.p000}`,
              border: `1px solid ${Common.color.p300}`,
            }}
            onClick={() => navigate(`/cart`)}
          >
            장바구니 바로가기
          </BigButton>
        </CartModalinfo>
      </CartModalWrap>
    </CartModalStyle>
  );
};

export default CartModal;
