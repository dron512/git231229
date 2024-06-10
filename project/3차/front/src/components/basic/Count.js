import React, { useState } from "react";
import styled from "@emotion/styled";
import {
  CounterButton,
  CounterValue,
  CounterWrapper,
} from "../../styles/basic/CountCss";

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
