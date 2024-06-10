import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const WrapMargin250 = styled.div`
  min-width: 1300px;
  padding: 130px 250px 130px 250px;
  /* background: rebeccapurple; */
`;

export const PayTitleCenter = styled.div`
  /* display: flex; */
  position: relative;
  justify-content: center;
  text-align: center;
  margin: 0 auto;
  /* background-color: aqua; */
  padding-bottom: 20px;
  img {
    position: relative;
    /* justify-content: center; */
    margin: 0 auto;
    display: flex;
  }
`;

export const PayUserInfo = styled.div`
  position: relative;
  padding: 20px 0 20px 0;
  border-bottom: 1px solid ${Common.color.p900};
`;

export const LineP500 = styled.div`
  width: 100%;
  height: 1px;
  background: ${Common.color.p400};
  margin: 20px 0 20px 0;
`;
export const InfoTable = styled.div`
  width: 100%;
  display: flex;
  position: relative;
  justify-content: space-between;
  /* border-top: 1px solid ${Common.color.p900}; */
  /* border-bottom: 1px solid ${Common.color.p900}; */
  margin: 10px 0 10px 0;
  p {
    margin: 10px;
  }
`;

export const DetailBigKeyword = styled.div`
  display: flex;
  min-height: 35px;
  .left {
    width: 90%;
    padding: 10px;
    width: 23%;
    border-bottom: 1px solid ${Common.color.p400};
    display: flex;
    align-items: center;
    /* justify-content: center; */
    /* font-size: 1.5rem; */
    font-weight: 500;
    text-align: left;
  }
  .right {
    width: 90%;
    border-bottom: 1px solid ${Common.color.p400};
    display: flex;
    align-items: center;
    padding-left: 20px;
  }
`;
