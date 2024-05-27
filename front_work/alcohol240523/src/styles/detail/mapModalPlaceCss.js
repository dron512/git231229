import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const PlaceWrap = styled.div`
  /* background-color: aquamarine; */
  position: relative;
  display: flex;
  /* gap: 50px; */
  margin: 40px 20px 20px 20px;
  cursor: pointer; /* 커서를 포인터로 변경하여 클릭 가능한 요소임을 나타냄 */
  /* justify-content: space-between; */
  /* overflow: scroll; */
  &:hover {
    background-color: ${Common.color.p300}; /* 마우스 호버 시 배경색 변경 */
  }
  ${props =>
    props.isActive &&
    `
    background-color: ${Common.color.p300};
  `}
`;

export const Placehead = styled.div`
  position: relative;
  display: flex;
  width: 200px;
  align-items: center;
  /* background-color: red; */
  /* overflow: hidden; */
`;

export const PlaceUl = styled.div`
  position: relative;
  align-items: center;
  /* gap: 50px; */
  text-align: left;
  width: 300px;
  /* background-color: rebeccapurple; */
  img {
    width: 20px;
    height: 20px;
  }
`;
export const PlaceLi = styled.div`
  position: relative;
  display: flex;
  align-items: center;
  /* background-color: blue; */
  margin-bottom: 20px;

  /* width: 110px; */
  gap: 20px;
  img {
    width: 20px;
    height: 20px;
  }
`;
