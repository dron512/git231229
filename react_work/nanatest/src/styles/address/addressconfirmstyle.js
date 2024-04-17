import styled from "styled-components";

export const AddressWrap = styled.div`
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 9999;
  width: 400px;
  height: 224px;
  border: 1px solid #868686;
  background: #fff;
  box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.25);
  padding-top: 48px;
  border-radius: 20px;
  h2 {
    color: #f24747;
    text-align: center;
    font-size: 30px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
  }
`;

export const AddressBtWrap = styled.div`
  width: 328px;
  height: 56px;
  border-radius: 38.5px;
  flex-shrink: 0;
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
  button {
    width: 155px;
    height: 56px;
    flex-shrink: 0;
    border-radius: 38.5px;
    border: none;
  }
`;
