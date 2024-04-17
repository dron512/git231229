import styled from "@emotion/styled";

export const LoginPageWrap = styled.div`
  min-width: 1440px;
  height: 1024px;
`;
export const LoginHeader = styled.header`
  height: 120px;
  position: relative;
  margin: 0 auto;
  display: flex;
  align-items: end;
  justify-content: center;
`;

export const LoginMain = styled.main`
  display: block;
  height: auto;
`;

export const LoginBox = styled.div`
  display: flex;
  justify-content: center;
  img {
    padding-bottom: 30px;
    display: flex;
    justify-content: center;
    width: 525px;
    height: 178px;
  }
`;

export const LoginBtArea = styled.div`
  display: flex;
  margin: 0 auto;
`;

export const LoginPageBt = styled.button`
  display: block;
  margin: 0 auto;
  border: none;
  background: transparent;
  color: #c5c5c5;
  cursor: pointer;
  h1 {
    margin-top: 10px;
    margin-bottom: 5px;
    font-weight: 400;
    font-size: 15px;
  }
  h3 {
    font-size: 25px;
    font-weight: 400;
    margin-bottom: 5px;
  }
`;

export const LoginFooter = styled.footer`
  width: 100%;
  height: 150px;
  display: flex;
  justify-content: center;
  align-items: end;
  color: #d9d9d9;
`;

export const FindBt = styled.div`
  display: flex;
  justify-content: center;
  margin-bottom: 40px;
  button {
    font-size: 15px;
    margin: 0 95px;
    border: none;
    background: transparent;
  }
`;
