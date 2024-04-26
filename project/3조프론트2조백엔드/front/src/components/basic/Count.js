import React, { useState } from "react";
import styled from "@emotion/styled";

const CounterWrapper = styled.div`
  display: flex;
  align-items: center;
  gap: 10px;
  /* margin-top: 20px; */
  margin: 0 10px 0 10px;
`;

const CounterValue = styled.div`
  font-size: 16px;
  font-weight: bold;
`;

const CounterButton = styled.button`
  /* padding: 0px 14px; */
  /* font-size: 30px; */
  width: 30px;
  height: 30px;
  background-color: #fff;
  /* text-align: center; */
  /* width: 30px; */
  /* height: 30px; */
  cursor: pointer;
  border: 1px solid #868686;

  &:hover {
    background-color: #868686;
  }
  img {
    width: 20px;
    height: 20px;
    border: none;
  }
`;

const Count = ({ count, setCount }) => {
  const increment = () => {
    setCount(count + 1);
  };

  const decrement = () => {
    if (count === 1) {
      setCount(1);
    } else {
      setCount(count - 1);
    }
  };

  return (
    <CounterWrapper>
      <CounterButton onClick={decrement}>
        <img
          style={{ width: "13px", height: "13px" }}
          src={process.env.PUBLIC_URL + "/images/minus.svg"}
        />
      </CounterButton>
      <CounterValue>{count}</CounterValue>
      <CounterButton
        style={{ fontSize: "20px", fontWeight: "bold" }}
        onClick={increment}
      >
        {/* <img src={process.env.PUBLIC_URL + "/images/plus.svg"} /> */}+
      </CounterButton>
    </CounterWrapper>
  );
};

export default Count;
