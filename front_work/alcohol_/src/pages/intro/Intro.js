import styled from "@emotion/styled/macro";
import React from "react";

const Intro = () => {
  const Test = styled.div`
    position: relative;
    height: 100px;
    background-color: aqua;
    margin: 0 auto;
  `;
  return (
    <Test>
      <div>
        <h1>테스트해봅시다</h1>
      </div>
    </Test>
  );
};

export default Intro;
