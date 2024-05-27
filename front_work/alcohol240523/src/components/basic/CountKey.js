import React, { useEffect } from "react";
import styled from "@emotion/styled";
import {
  CounterButton,
  CounterValue,
  CounterWrapper,
} from "../../styles/basic/CountCss";
import { useRecoilState, useRecoilValue } from "recoil";
import { cartCountState } from "../../atom/CountState";

const CountKey = ({ id, count }) => {
  // Recoil 상태와 상태 업데이트 함수를 가져오기
  const [cartCount, setCartCount] = useRecoilState(cartCountState);

  const handleMinus = () => {
    setCartCount(prevCart => ({
      ...prevCart,
      [id]: Math.max((prevCart[id] || 0) - 1, 0),
    }));
  };

  const handlePlus = () => {
    setCartCount(prevCart => ({
      ...prevCart,
      [id]: (prevCart[id] || 0) + 1,
    }));
  };

  console.log("cartCount:", cartCount);

  console.log("id:", count);
  return (
    <CounterWrapper>
      <CounterButton onClick={handleMinus}>
        <img
          style={{ width: "13px", height: "13px" }}
          src={process.env.PUBLIC_URL + "/images/minus.svg"}
          alt="minus"
        />
      </CounterButton>
      <CounterValue>{cartCount[id]}</CounterValue>
      <CounterButton style={{ fontSize: "16px" }} onClick={handlePlus}>
        <img
          style={{ width: "13px", height: "13px" }}
          src={process.env.PUBLIC_URL + "/images/plus.svg"}
          alt="minus"
        />
      </CounterButton>
    </CounterWrapper>
  );
};

export default CountKey;
