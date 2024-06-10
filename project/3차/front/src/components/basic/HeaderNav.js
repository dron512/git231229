import styled from "@emotion/styled/macro";
import React from "react";
import { Common } from "../../styles/CommonCss";

const HeaderNav = ({ mainNm, mainId, subNm, subId, active, onClick }) => {
  const isSub = subNm && subId;
  const fontSize = isSub ? "16px" : "20px";
  const fontWeight = isSub ? (active ? "bold" : "normal") : "bold";
  const textDecoration = active ? "underline" : "none";
  //   const fontWeight = active ? "underline" : "none";
  const margin = isSub ? "10px" : "20px";

  const SideBtStyled = styled.button`
    border: none;
    background: none;
    /* color: ${active ? Common.color.f900 : Common.color.p900}; */
    font-weight: ${fontWeight};
    text-decoration: ${textDecoration};
    margin-top: ${margin};
    cursor: pointer;
    font-size: ${fontSize};
    /* font-weight: ${active ? "bold" : "normal"}; */
  `;

  return (
    <div>
      <SideBtStyled onClick={onClick}>{isSub ? subNm : mainNm}</SideBtStyled>
    </div>
  );
};

export default HeaderNav;
