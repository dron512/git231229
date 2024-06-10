import styled from "@emotion/styled/macro";
import React, { useState } from "react";
import ReviewBt from "../../components/mypage/ReviewBt";
import { useNavigate } from "react-router-dom";
import CreateReview from "./CreateReview";

import { Common } from "../../styles/CommonCss";
import MyReview from "./MyReview";
import { MarginB10, MarginB20 } from "../../styles/common/reviewProductCss";
import { PB20 } from "../../styles/basic";

const ReviewPage = () => {
  const navigate = useNavigate();
  const [activeNavBt, setActiveNavBt] = useState(1);
  const handleBtClick = reBtId => {
    setActiveNavBt(reBtId);
    console.log("선택된 리뷰버튼", reBtId);
  };

  const InfoWrap = styled.div`
    width: 100%;
    position: relative;
    hr {
      background-color: ${Common.color.b900};
      height: 3px;
      /* margin-bottom: 20px; */
    }
  `;
  return (
    <InfoWrap>
      <MarginB10 />
      <PB20>상품리뷰</PB20>
      <MarginB20 />
      <div>
        <ReviewBt
          btName="작성 가능한 리뷰"
          reBtId={1}
          active={activeNavBt === 1}
          onClick={() => {
            handleBtClick(1);
          }}
        />
        <ReviewBt
          btName="내 리뷰"
          reBtId={2}
          active={activeNavBt === 2}
          onClick={() => handleBtClick(2)}
        />
      </div>
      <hr />
      <div className="page-content">
        {activeNavBt === 1 ? <CreateReview /> : <MyReview />}
      </div>
    </InfoWrap>
  );
};

export default ReviewPage;
