import styled from "@emotion/styled";
import { Common } from "../CommonCss";

export const CardContainer = styled.div`
  position: relative;

  padding: 16px;
  margin: 16px;
  overflow: hidden;

  .card-img {
    width: 306px;
    height: 306px;
    object-fit: cover;
    cursor: pointer;
    border-radius: 10px;
    border: 1px solid ${Common.color.p300};
  }

  .productNm {
    overflow: hidden;
    color: #595959;
    width: 260px;
    text-overflow: ellipsis;
    white-space: nowrap;
    font-family: "Noto Sans KR";
    font-size: 20px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
  }
  .price {
    color: #2d2d2d;

    font-family: "Noto Sans KR";
    font-size: 30px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
  }
`;

export const CardContainer2 = styled.div`
  padding: 16px;

  overflow: hidden;

  .card-img {
    width: 263px;
    height: 263px;
    object-fit: cover;
    cursor: pointer;
  }

  .productNm {
    overflow: hidden;
    color: #595959;
    width: 260px;
    text-overflow: ellipsis;
    white-space: nowrap;
    font-family: "Noto Sans KR";
    font-size: 20px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
  }
  .price {
    color: #2d2d2d;

    font-family: "Noto Sans KR";
    font-size: 30px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
  }
`;

export const CardFlex = styled.div`
  position: relative;
  display: flex;
  /* align-items: center; */
  width: 263px;
  /* justify-content: space-between; */
  margin-top: 10px;
  margin-bottom: 10px;

  .tagform {
    display: flex;
    align-items: center;
    justify-content: center;
    img {
      width: 20px;
      height: 20px;
      margin-right: 5px;
    }
  }
  p {
    font-size: 16px;
    font-weight: bold;
  }
  .wish-bt {
    border: none;
    background: transparent;
    cursor: pointer;
    img {
      width: 25px;
      height: 25px;
    }
  }
`;

export const HeartButton = styled.button`
  width: 16px;
  height: 16px;
  background: none;
  border: none;
  cursor: pointer;

  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    cursor: pointer;
    filter: ${({ checked }) => (checked ? "none" : "grayscale(100%)")};
  }
`;
export const TagStyle = styled.div`
  width: 77px;
  height: 28px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 50px;
  ${({ color, borderColor, letterSpacing }) => `
    border: 1px solid ${borderColor};
    color: ${color};
    letter-spacing: ${letterSpacing};
  `}
  text-align: left;

  font-size: 15px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
`;
