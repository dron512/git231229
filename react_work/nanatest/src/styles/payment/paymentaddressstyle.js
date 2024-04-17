import styled from "@emotion/styled";
export const PostNum = styled.div`
  display: flex;
  line-height: 40px;
  margin-bottom: 7px;
  p {
    font-size: 18px;
    color: #575757;
    margin-right: 20px;
  }
  .postNumDiv {
    width: 150px;
    height: 40px;
    display: table-cell;
    vertical-align: middle;
    text-align: center;
    border: #d9d9d9 1px solid;
    margin-right: 10px;
  }
  i {
    font-size: 15px;
    color: #575757;
    font-style: normal;
    display: flex;
    justify-content: center;
    align-items: center;
  }
`;
export const Detailadress = styled.div`
  div {
    width: 100%;
    border: 1px solid #d9d9d9;
    height: 40px;
    margin-bottom: 7px;
  }
  p {
    font-size: 15px;
    line-height: 37px;
    color: #575757;
    margin-left: 10px;
  }
`;
export const Selectadress = styled.div`
  margin-top: 30px;
  margin-bottom: 30px;
  margin-right: 0;
  .adressTextDiv {
    border: 1px solid #d9d9d9;
    height: 40px;
    width: 1500px;
    display: table-cell;
    vertical-align: middle;
    p {
      font-size: 15px;
      margin-left: 10px;
      color: #575757;
    }
  }
  .custom-radio span.ant-radio + * {
    padding-inline-end: 0;
  }
`;