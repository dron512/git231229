import styled from "@emotion/styled";

export const OpenOrderbt = styled.button`
  border: "none";
  background: #f24747;
  border: 1px solid #868686;
  border-radius: 5px;
  cursor: pointer;
  /* width: 80%; */
  width: 80px;
  color: #fff;
  text-align: center;

  font-size: 12px;
  font-style: normal;
  font-weight: 400;
  line-height: 24px;
  letter-spacing: 0.5px;
`;

export const OrderModalWrap = styled.div`
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 9999;
  width: 500px;
  height: 300px;
  border: 1px solid #868686;
  background: #fff;
  box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.25);
  padding-top: 48px;
  border-radius: 20px;
  /* h2 {
  color: #f24747;
  text-align: center;
  font-size: 30px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
} */
  .modal-content {
    position: relative;
    h2 {
      color: #f24747;
      text-align: center;
      font-size: 30px;
      font-style: normal;
      /* font-weight: 700; */
      line-height: normal;
    }
    .return-input {
      display: flex;
      /* margin-top: 30px; */
      top: 50%;
      color: #868686;
      width: 350px;
      height: 40px;
      font-size: 15px;
      border-radius: 5px;
      border: 1px solid #868686;
      /* text-align: center; */
      margin: 0 auto;
      margin-top: 50px;
    }
    .return-input::placeholder {
      padding-left: 20px;
    }
  }
`;

export const OrderModalBtWrap = styled.div`
  width: 250px;
  height: 56px;
  border-radius: 38.5px;
  /* flex-shrink: 0; */
  text-align: center;
  font-size: 20px;
  font-style: normal;
  font-weight: 500;
  line-height: normal;
  margin: 0 auto;
  display: flex;
  justify-content: center;
  gap: 26.5px;
  padding-top: 30px;
  .modal-bt {
    width: 150px;
    height: 56px;
    flex-shrink: 0;
    border-radius: 7px;
    border: none;
  }
`;

export const RuturnModalBtWrap = styled.div`
  width: 250px;
  /* height: 56px; */
  border-radius: 38.5px;
  /* flex-shrink: 0; */
  text-align: center;
  font-size: 20px;
  font-style: normal;
  font-weight: 500;
  line-height: normal;
  margin: 0 auto;
  display: flex;
  justify-content: center;
  gap: 26.5px;
  /* padding-top: 100px; */

  .modal-bt {
    width: 150px;
    height: 56px;
    flex-shrink: 0;
    border-radius: 7px;
    border: none;
  }
`;

export const CancelModalBtWrap = styled.div`
  width: 250px;
  height: 56px;
  border-radius: 38.5px;
  /* flex-shrink: 0; */
  text-align: center;
  font-size: 20px;
  font-style: normal;
  font-weight: 500;
  line-height: normal;
  margin: 0 auto;
  display: flex;
  justify-content: center;
  gap: 26.5px;
  padding-top: 100px;
  .modal-bt {
    width: 150px;
    height: 56px;
    flex-shrink: 0;
    border-radius: 7px;
    border: none;
  }
`;
