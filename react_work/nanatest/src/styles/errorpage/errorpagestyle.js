import styled from "styled-components";

export const ErrorWrap = styled.div`
  width: 760px;
  height: 600px;

  margin: 200px auto;
`;

export const ErrorImg = styled.div`
  position: absolute;
  display: inline-block;
  /* z-index: -1; */
  img {
    width: 281px;
    height: 300px;
    z-index: -1;
  }
`;

export const ErrorLogo = styled.div`
  display: flex;
  justify-content: center;
  img {
    width: 415px;
    height: 140px;
  }
`;

export const ErrorMainTxt = styled.h2`
  color: #e9b25f;
  text-align: center;
  font-size: 50px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
  margin-bottom: 25px;
`;

export const ErrorSubTxt = styled.h3`
  height: 83px;
  color: #868686;
  text-align: center;
  font-size: 18px;
  font-style: normal;
  font-weight: 400;
  line-height: 25px;
`;

export const ErrorBt = styled.button`
  display: flex;
  width: 759px;
  height: 90px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  background: #e9b25f;
  border-radius: 10px;
  border: none;
  font-size: 40px;
  color: #fff;
  cursor: pointer;
`;
