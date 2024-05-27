import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const TotalPayWrap = styled.div`
  position: relative;
  /* display: flex; */
  width: 100%;

  /* margin: 20px; */
  border-top: 1px solid ${Common.color.p900};
`;

export const TotalTh = styled.div`
  width: 100%;
  /* justify-content: space-between; */
  padding: 40px 20px; /* 상하 20px, 좌우 20px */
  border-bottom: 1px solid ${Common.color.p200};
  text-align: center;
  display: grid;
  grid-template-columns: repeat(4, 300px);

  > * {
    grid-column: span 1;
    grid-row: span 1;
  }
`;

export const JusCenter = styled.div`
  display: flex;
  justify-content: center;
`;
