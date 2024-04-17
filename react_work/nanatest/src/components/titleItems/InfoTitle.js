import styled from "@emotion/styled";
import React from "react";

export const InfoTitle = ({ infoText }) => {
  const IfTitle = styled.div`
    font-size: 20px;
    color: #d68000;
    height: 101px;
    position: block;
    /* background-color: aqua; */
    display: flex;
    align-items: center;
    /* margin-top: auto; */
    h1 {
    }
  `;
  // console.log("infoText", { infoText });
  return (
    <IfTitle>
      <h1>{infoText}</h1>
    </IfTitle>
  );
};

export default InfoTitle;
