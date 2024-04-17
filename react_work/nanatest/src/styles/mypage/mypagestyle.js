import styled from "@emotion/styled";

export const MyPageWrap = styled.div`
  display: block;
  width: 1440px;
  height: auto;
  margin: 30px auto;
`;

export const MyPageHeader = styled.header`
  width: 1157px;
  margin-bottom: 42px;
  margin: 0 auto;
  h2 {
    width: 291px;
    height: 101px;
    font-size: 70px;
    font-weight: 500;
    color: #e9b25f;
  }
`;

export const InfoHead = styled.div`
  width: 1157px;
  border-top: solid 1px #c5c5c5;
  margin: 0 auto;
`;

export const InfoTitle = styled.h2`
  color: #868686;
  text-align: center;
  font-size: 12px;
  font-style: normal;
  font-weight: 500;
  line-height: 24px; /* 200% */
  letter-spacing: 0.5px;
  margin: 17px 0;
`;

export const InfoWrap = styled.div`
  width: 1157px;
  height: 151px;
  border-top: solid 1px #c5c5c5;
  border-bottom: solid 1px #c5c5c5;
`;

export const InfoMain = styled.div`
  display: flex;
  width: 1157px;
  height: 97px;
  justify-content: space-around;
  align-items: center;
  margin: 26px 0;

  div {
    color: #868686;
    font-size: 12px;
    font-style: normal;
    font-weight: 400;
    line-height: 24px; /* 200% */
    letter-spacing: 0.5px;
    ::after {
      content: none;
      border: solid 1px #d9d9d9;
    }
  }
  h2 {
    text-align: center;
  }
`;

export const InfoBtWrap = styled.div`
  display: flex;
  justify-content: center;
  width: auto;
  height: 70px;
  gap: 40px;
  margin: 52px auto;
`;

export const InfoBt = styled.button`
  width: 240px;
  height: 70px;
  background: #e9b25f;
  border: none;
  font-weight: 500;
  font-size: 20px;
  color: #ffffff;
`;

export const ProductWrap = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: end;
  width: 1157px;
  height: auto;
  margin: 0 auto;
  h2 {
    font-size: 70px;
    font-weight: 500;
    color: #e9b25f;
  }
  h3 {
    font-size: 20px;
    font-weight: 400;
    text-align: end;
    line-height: 50px;
    color: #949494;
  }
`;

export const MyWishWrap = styled.div`
  width: 1156px;
  height: 1182px;
  margin: 0 auto;
  display: flex;
`;
