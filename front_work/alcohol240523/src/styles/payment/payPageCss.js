import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const PayWrap = styled.div`
  position: relative;
  padding: 120px;
  background-color: aquamarine;
  width: 100%;
`;

export const PayHeader = styled.div`
  position: relative;
  display: flex;
  width: 100%;
  gap: 20px;
`;

export const PayHeaderR = styled.div`
  position: relative;
  /* display: flex; */
  width: 500px;
  background-color: rebeccapurple;
  padding: 20px;
  border-left: 1px solid ${Common.color.p900};
`;
