import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const ProCardContainer = styled.div`
  position: relative;
  overflow: hidden;

  .card-img {
    min-width: 240px;
    height: 240px;
    object-fit: cover;
    cursor: pointer;
    border-radius: 10px;
    border: 1px solid ${Common.color.p300};
  }

  .productNm {
    color: ${Common.color.p700};
    width: 250px;
    font-family: "Noto Sans KR";
    font-size: 16px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  .price {
    color: #2d2d2d;
    width: 250px;
    font-family: "Noto Sans KR";
    font-size: 20px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
  }
`;
