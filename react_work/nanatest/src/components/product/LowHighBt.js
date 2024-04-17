import styled from "@emotion/styled";
import React, { useState } from "react";

export const LowHighFilterContainer = styled.div`
  display: flex;
  justify-content: flex-end;
  margin: 0 auto;
  max-width: 1280px;
`;

export const LowHighFilter = styled.button`
  border: none;
  background: #fff;
  color: ${props => (props.active ? "#e9b25f" : "#bababa")};
  text-align: center;
  font-family: Noto Sans KR;
  font-size: 12px;
  font-style: normal;
  line-height: normal;
  height: 35px;
  margin-right: 10px;
  padding-top: 20px;
  cursor: pointer;
`;

// LowHighBt 컴포넌트
const LowHighBt = ({
  onChangeSortBy,
  setUserSearchActive,
  activeLHFilter,
  setActiveLHFilter,
}) => {
  const handleClickLowHigh = filter => {
    // 검색 가능하도록 true 변경
    if (setUserSearchActive != null) {
      setUserSearchActive(true);
    }

    setActiveLHFilter(filter);
    onChangeSortBy(filter);
  };

  return (
    <LowHighFilterContainer>
      <LowHighFilter
        onClick={() => handleClickLowHigh(0)}
        active={activeLHFilter === 0}
      >
        최신순
      </LowHighFilter>

      <LowHighFilter
        onClick={() => handleClickLowHigh(2)}
        active={activeLHFilter === 2}
      >
        낮은가격순
      </LowHighFilter>
      <LowHighFilter
        onClick={() => handleClickLowHigh(1)}
        active={activeLHFilter === 1}
      >
        높은가격순
      </LowHighFilter>
    </LowHighFilterContainer>
  );
};

export default LowHighBt;
