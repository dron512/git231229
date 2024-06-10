import React from "react";
import { P13, P16, P20, PB20 } from "../../styles/basic";
import { StarRev } from "../../styles/common/StarCss";
import styled from "@emotion/styled/macro";
import { Common } from "../../styles/CommonCss";
import {
  MarginB20,
  RvForm,
  RvWrap,
} from "../../styles/common/reviewProductCss";

const ReviewProduct = ({ userNm, starCount, review, date }) => {
  const stars = Array.from({ length: starCount }, (_, index) => (
    <img
      key={index}
      src={process.env.PUBLIC_URL + "/images/star.png"}
      alt={`Star ${index + 1}`}
      style={{ width: "20px", height: "20px" }} // 이미지 너비와 높이를 조정할 수 있습니다.
    />
  ));

  return (
    <RvWrap>
      <RvForm>
        <RvForm>
          <P16>{userNm}</P16>
          <StarRev>{stars}</StarRev>
        </RvForm>

        <P13>{date}</P13>
      </RvForm>
      <MarginB20 />
      <P13>{review}</P13>
    </RvWrap>
  );
};

export default ReviewProduct;
