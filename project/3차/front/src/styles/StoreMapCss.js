import styled from "@emotion/styled/macro";
import { Common } from "./CommonCss";

export const StoreWrap = styled.div`
  position: relative;
  display: flex;
  min-width: 1000px;
  gap: 20px;
  border: none; /* 테두리 제거 */
  margin: 0 auto;
`;

export const StoreInfo = styled.div`
  position: relative;
  min-width: 400px;
  justify-content: center;
  text-align: center;
  background: aqua; /* 배경색 제거 */
`;

export const MyLocation = styled.div`
  position: relative;
  display: flex;

  width: 400px;
  height: 50px;
  justify-content: space-between;
  text-align: center;
  border-radius: 10px;
  align-items: center;
  padding: 0 20px;
  border: 2px solid ${Common.color.p500};
`;

export const LocationBox = styled.div`
  position: relative;

  min-width: 400px;
  align-items: center;
  padding: 20px 10px;

  border-bottom: 2px solid ${Common.color.p200};
  .branch {
    position: relative;
    display: flex;
    gap: 5px;
    /* margin-bottom: 20px; */
  }
`;

export const MarketWrap = styled.div`
  /* background-color: red; */
  height: 500px;
  overflow: scroll;
`;
