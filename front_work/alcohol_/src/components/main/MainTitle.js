import styled from "@emotion/styled/macro";
import React from "react";

const MainTitle = ({ mainText }) => {
  const MainTitle = styled.div`
    position: relative;
    text-align: center;
    margin: 30px 0;
    p {
      font-size: 30px;
      font-weight: bold;
    }
  `;
  return (
    <div>
      <MainTitle>
        <p>{mainText}</p>
      </MainTitle>
    </div>
  );
};

export default MainTitle;
