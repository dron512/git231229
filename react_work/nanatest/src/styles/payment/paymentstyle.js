import styled from "@emotion/styled";
export const PaymentWrap = styled.div`
  margin: 0 auto;
  hr {
    border: none;
    background-color: #e9b25f;
    height: 1px;
    margin-bottom: 30px;
  }
  .paymentListTitle {
    font-size: 25px;
    color: #e9b25f;
    font-weight: 500;
    font-style: normal;
    margin-bottom: 20px;
  }
`;
export const PaymentBody = styled.div`
  width: 1110px;
  margin: 0 auto;
`;
export const PaymentHeader = styled.div`
  p {
    font-size: 70px;
    color: #e9b25f;
    margin-top: 80px;
    margin-bottom: 50px;
    text-align: center;
    font-weight: 500;
  }
`;
export const PaymentFooter = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
  margin-bottom: 60px;
  font-size: 15px;
`;
export const PayMethodWrap = styled.div`
  display: flex;
  justify-content: space-between;
`;

export const PaymentMethod = styled.button`
  margin-bottom: 30px;
  opacity: 0.5;
  border-radius: 10px;
  border: none;
  transition: 0.5s;
  cursor: pointer;
  &:disabled {
    opacity: 0.5;
  }
  &:hover {
    opacity: 1;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
  }
  &.active-button {
    opacity: 1;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
  }
  .bankTransfer {
    border: 1px solid #d9d9d9;
    background-color: #f6f6f6;
    width: 550px;
    height: 206px;
    border-radius: 10px;
    display: flex;
    justify-content: space-around;
    align-items: center;
    gap: 30px;
    img {
      width: 130px;
    }
    p {
      font-size: 35px;
      color: #868686;
    }
  }
  .creditCard {
    border: 1px solid #d9d9d9;
    background-color: #f6f6f6;
    width: 550px;
    height: 206px;
    border-radius: 10px;
    display: flex;
    justify-content: space-around;
    align-items: center;
    gap: 30px;
    img {
      width: 130px;
    }
    p {
      font-size: 35px;
      color: #868686;
    }
  }
`;
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
    line-height: 40px;
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

// 주문 목록
export const OrderProduct = styled.div`
  font-size: 15px;
  color: #575757;
  display: flex;
  height: 120px;
  justify-content: space-between;
  width: 1110px;
  margin-bottom: 30px;
  img {
    width: 120px;
    height: 120px;
    object-fit: cover;
  }
  .productImgDesc {
    display: flex;
  }

  .productNameTex {
    margin-left: 20px;
    height: 120px;
    display: flex;
    justify-content: space-between;
    flex-direction: column;
  }
  .countPrice {
    height: 120px;
    margin-right: 0px;
    display: flex;
    flex-direction: column;
    justify-content: flex-end;
    text-align: end;
  }
`;
export const PaymentInfo = styled.div`
  hr {
    border: none;
    background-color: #e9b25f;
    height: 1px;
    margin-bottom: 30px;
  }
`;

export const TotalOrder = styled.div`
  display: flex;
  justify-content: space-between;
  height: 350px;
  margin-bottom: 30px;
  .orderPrice {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    width: 740px;
  }
  .orderPriceDiv {
    justify-content: space-between;
    display: flex;
    font-size: 15px;
    color: #575757;
  }
`;
export const OrderInfo = styled.div`
  margin-bottom: 30px;
  .InfoDetail {
    font-size: 15px;
    display: flex;
    margin-bottom: 10px;
    div {
      width: 100px;
      line-height: 40px;
    }
  }
`;

export const ModalPop = styled.div`
  position: fixed;
  display: flex;
  align-items: center;
  justify-content: center;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.7);
  z-index: 999;
  .modalBack {
    background: #fff;
    text-align: center;
    width: 300px;
    height: 150px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    border-radius: 10px;
  }
  button {
    height: 30px;
  }
`;
export const ModalButton = styled.div`
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
  button {
    height: 30px;
    width: 150px;
    border-radius: 30px;
    background-color: #d68000;
    border: none;
    color: #ffffff;
  }
`;
