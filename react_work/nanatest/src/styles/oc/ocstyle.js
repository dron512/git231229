import styled from "styled-components";

// OCForm.js
export const OcPadding = styled.div`
  width: 1440px;
  padding: 110px 0;
  display: flex;
  justify-content: center;
  align-items: center;
`;
export const OcWrap = styled.div`
  width: 1290px;
  /* height: 1520px; */
  background: #fff;
  box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.1);
  padding: 50px;
`;
// OCInfo.js
export const BorderWrap = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  .pageMargin {
    margin-bottom: 50px;
  }

  .orderInfoTitle {
    height: 60px;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    p {
      font-size: 20px;
      color: #e9b25f;
      text-align: left;
      margin-left: 35px;
      font-weight: 600;
    }
  }
`;
export const BorderLinemanager = styled.table`
  border-collapse: collapse;
  border-bottom: 3px solid #e9b25f;
  border-top: 3px solid #e9b25f;

  td {
    border-left: 1px solid #d9d9d9;
    border-bottom: 1px solid #d9d9d9;

    &:first-child {
      border-left: none;
    }
  }

  .tableName {
    font-size: 16px;
    height: 50px;
    width: 190px;
    text-align: left;

    p {
      margin-left: 35px;
    }
  }

  .tableDesc {
    font-size: 16px;
    height: 50px;
    width: 960px;
    text-align: left;

    p {
      margin-left: 35px;
    }
  }
`;

// OCMessage.export js
export const OCMWrap = styled.div`
  width: 1150px;
  height: 450px;
  display: flex;
  justify-content: center;
  align-items: center;
`;
export const OCMDiv = styled.div`
  width: 820px;
  height: 200px;
  display: flex;
  gap: 80px;
  justify-content: center;
  align-items: center;
`;
export const OCMtd = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 150px;
`;
export const OCMText = styled.div`
  p {
    font-size: 30px;
    font-weight: 600;
    color: #e9b25f;
  }
  span {
    font-size: 20px;
    color: #595959;
    font-weight: 500;
  }
`;

export const OCMDesc = styled.div`
  p {
    font-size: 20px;
    color: #595959;
    font-weight: 500;
  }
`;

export const OcDetailWrap = styled.div`
  width: 1150px;
  margin: 0 auto;
  .orderInfoTitle {
    height: 60px;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    p {
      font-size: 20px;
      color: #e9b25f;
      text-align: left;
      margin-left: 35px;
      font-weight: 600;
    }
  }
`;
