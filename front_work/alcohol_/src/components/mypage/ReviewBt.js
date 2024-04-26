import styled from "@emotion/styled/macro";
import React from "react";
import { Common } from "../../styles/CommonCss";

const ReviewBt = ({ active, btName, onClick }) => {
  const ReviewBtStyled = styled.button`
    width: 159px;
    height: 45px;
    background: ${active ? Common.color.b900 : Common.color.p000};
    border: ${active ? "none" : `1px solid ${Common.color.p300}`};
    color: ${active ? Common.color.p000 : Common.color.p300};
    font-size: 13px;
    cursor: pointer;
  `;
  return (
    <>
      <ReviewBtStyled onClick={onClick}>{btName}</ReviewBtStyled>
    </>
  );
};

export default ReviewBt;
