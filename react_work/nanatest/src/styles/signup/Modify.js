import { Button, Radio } from "antd";
import styled from "styled-components";

export const ModifyEventInfo = styled.div`
  border: 5px solid #d9d9d9;
  width: 1220px;
  height: 190px;
  margin-top: 5rem;
  padding-left: 3rem;
  padding-top: 3rem;

  .ModifyEventInfo-ing {
    border-bottom: 3px solid #d9d9d9;
    width: 1116px;
    height: 15px;
    margin-bottom: 1rem;
    padding-bottom: 3rem;
  }
`;

export const ModifyInfo = styled.div`
  border-top: 3px solid #868686;
  border-bottom: 3px solid #868686;
  padding: 20px 0;
  color: #868686;
  font-family: Noto Sans KR;
  font-size: 20px;
  font-style: normal;
  font-weight: 500;
  line-height: normal;
  width: 1220px;
`;

export const ModifyBt = styled.div`
  display: flex;
  padding-top: 50px;
  width: 59%;
  justify-content: space-between;

  .ModifyBt-two {
    display: flex;
    gap: 10px;
  }
`;

export const modifyInfo = {
  margin: "0 auto",
  width: 1220,
  padding: "80px 0",
};
export const modifyInputBt = {
  width: 1220,
  height: 50,
};
export const modifybabyInfo = {
  display: "flex",
  gap: 20,
  borderBottom: "3px solid #C5C5C5",
  paddingBottom: 50,
};
export const modifybabyInfoPush = {
  color: "#E9B25F",
  fontFamily: "Noto Sans KR",
  fontSize: "50px",
  fontStyle: "normal",
  fontWeight: 700,
  lineHeight: "normal",
};

export const modifyAdd = {
  backgroundColor: "#E9B25F",
  width: "115px",
  height: "50px",
  marginTop: "1rem", // 추가: 버튼 위 간격 조절을 위한 속성
};

export const modifyWithdrawal = {
  border: "1px solid #FF4E4E",
  backgroundColor: "#FFF",
  color: "#FF4E4E",
  width: "110px",
  height: "50px",
  marginTop: "1rem",
  // 추가: 버튼 위 간격 조절을 위한 속성\
};
export const modifyInfoBt = {
  background: "#D68000",
  width: "110px",
  height: "50px",
  marginTop: "1rem",
  paddingLeft: "12px", // 추가: 버튼 위 간격 조절을 위한 속성\
};

export const modifyCancel = {
  background: "#868686",
  width: "110px",
  height: "50px",
  marginTop: "1rem", // 추가: 버튼 위 간격 조절을 위한 속성\
};
