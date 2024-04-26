import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const PlaceWrap = styled.div`
  /* background-color: aquamarine; */
  position: relative;
  display: flex;
  gap: 50px;
  margin: 40px 20px 20px 20px;
  cursor: pointer; /* 커서를 포인터로 변경하여 클릭 가능한 요소임을 나타냄 */
  &:hover {
    background-color: ${Common.color.p300}; /* 마우스 호버 시 배경색 변경 */
  }
  ${props =>
    props.isActive &&
    `
    background-color: ${Common.color.p300};
  `}
`;
export const PlaceUl = styled.div`
  position: relative;
  align-items: center;
  gap: 50px;
  img {
    width: 20px;
    height: 20px;
  }
`;
export const PlaceLi = styled.div`
  position: relative;
  display: flex;
  align-items: center;
  margin-bottom: 20px;
  gap: 20px;
  img {
    width: 20px;
    height: 20px;
  }
`;
