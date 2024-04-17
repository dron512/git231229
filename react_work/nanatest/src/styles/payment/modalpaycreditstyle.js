import styled from "@emotion/styled";
export const ModalWrap = styled.div`
  position: relative;
  display: block;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const ModalBody = styled.div`
  /* position: relative;
  transform: translate(75%, 25%); */
  background-color: white;
  display: block;
  width: 400px;
`;
export const ModalHeader = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 15px;
  margin-top: 20px;
  p {
    font-size: 20px;
  }
`;
export const TotalAmount = styled.div`
  width: 100%;
  height: 80px;
  border-radius: 10px;
  background-color: #ddf1ff;
  padding: 12px;
  margin-bottom: 20px;
  p {
    font-size: 12px;
  }
  b {
    font-size: 30px;
    line-height: 40px;
  }
`;
export const CardNum = styled.div`
  gap: 12px;
  margin-bottom: 15px;
  p {
    font-size: 16px;
    margin-bottom: 5px;
  }
`;
export const CvcNum = styled.div`
  gap: 12px;
  margin-bottom: 30px;
  p {
    font-size: 16px;
    margin-bottom: 5px;
  }
`;
export const AgreeCheckBox = styled.div`
  gap: 12px;
  margin-bottom: 10px;
  p {
    font-size: 12px;
  }
`;
export const ModalFooter = styled.div`
  width: 348px;
  .footerButton {
    background-color: #42b0ff;
  }
`;
