import styled from "@emotion/styled";
import React from "react";

const MainItemBoxTag = ({ txt, type }) => {
  let borderColor, textColor;

  if (type === 0) {
    borderColor = "transparent";
    textColor = "transparent";
  } else if (type === 1) {
    borderColor = "#ff4f4f";
    textColor = "#ff4f4f";
  } else if (type === 2) {
    borderColor = "#4f95ff";
    textColor = "#4f95ff";
  }

  const ItemTagBox = styled.div`
    border-radius: 50px;
    border: 1px solid;
    border-color: ${borderColor};
    width: 70px;
    height: 25px;
    justify-content: center;
    align-items: center;
    display: flex;

    span {
      color: ${textColor};
      font-size: 12px;
      line-height: 21px;
      letter-spacing: 0.5px;
    }
  `;

  return (
    <>
      <ItemTagBox>
        <span>{txt}</span>
      </ItemTagBox>
    </>
  );
};

export default MainItemBoxTag;
