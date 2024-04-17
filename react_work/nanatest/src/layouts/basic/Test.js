import styled from "@emotion/styled";
import React from "react";

const Test = () => {
  const TestPage = styled.div`
    height: 800px;
    width: 100%;
    .tete {
    }
  `;
  return (
    <TestPage>
      <div className="tete"></div>
    </TestPage>
  );
};

export default Test;
