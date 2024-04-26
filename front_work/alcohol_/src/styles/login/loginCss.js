import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";


// styled components
export const MyDiv = styled.div`
  display: flex;
  justify-content: center;
  padding: 3rem;
`;
export const LoginWrap = styled.div`
  min-width: 1300px;
  padding: 0 330px 0 330px;
`;
export const LoginTitle = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  .logo {
    font-size: 50px;
    font-weight: bold;
    padding-bottom: 130px;
  }
  .email-line {
    position: relative;
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: ${Common.color.p800};
    padding-bottom: 50px;
    /* padding: 20px 0 20px 0; */
    p {
      font-size: 20px;
    }
    .line {
      height: 2px;
      width: 30%;
      background: ${Common.color.p800};
    }
  }
  .login-line {
    position: relative;
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: ${Common.color.p800};
    padding: 20px 0 40px 0;
    p {
      font-size: 20px;
    }
    .line {
      height: 2px;
      width: 30%;
      background: ${Common.color.p800};
    }
  }
`;
export const LoginBt = styled.button`
  width: 100%;
  height: 60px;
  margin-bottom: 17px;
  border-radius: 8px;
  font-size: 20px;
  color: ${Common.color.p800};
  /* background: ${Common.color.y900}; */
  background: none;
  border: 1px solid ${Common.color.p500};
  cursor: pointer;
  img {
    width: 21px;
    margin-right: 10px;
  }
`;
