import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const RvModalStyle = styled.div`
  position: fixed;
  display: flex;
  align-items: center;
  justify-content: center;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.7);
  z-index: 999;
`;

export const MapModalWrap = styled.div`
  position: relative;

  min-width: 1000px;
  height: 600px;
  background-color: ${Common.color.p100};
  padding: 20px;
  margin: 0 auto;
  overflow-y: scroll;
  scroll-behavior: smooth;
`;

export const CloseBt = styled.button`
  width: 20px; /* 이미지의 너비 조정 */
  height: 20px;
  padding: 0; /* 패딩 제거 */
  background: none; /* 배경색 제거 */
  border: none;
  cursor: pointer;
  img {
    width: 20px; /* 이미지의 너비 조정 */
    height: 20px;
  }
`;
export const MapWrap = styled.button`
  position: relative;
  display: flex;
  justify-content: space-between;
  gap: 20px;
  display: flex;
  justify-content: space-between;
  height: 500px;
  padding: 0; /* 패딩 제거 */
  background: none; /* 배경색 제거 */
  border: none; /* 테두리 제거 */
`;

export const Place = styled.div`
  position: relative;
  width: 500px;
  /* display: flex; */
  justify-content: center;
  text-align: center;
`;
