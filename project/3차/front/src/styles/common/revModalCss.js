import styled from "@emotion/styled/macro";
import { Common } from "../CommonCss";

export const RvModalStyle = styled.div`
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
`;
export const ModalWrap = styled.div`
  position: relative;
  min-width: 870px;
  height: 600px;
  background-color: ${Common.color.p100};
  padding: 20px;
  margin: 0 auto;
`;

export const ModalContent = styled.div`
  position: relative;
  width: 100%;
  /* background-color: aliceblue; */
  .modal-title {
    position: relative;
    display: flex;
    width: 100%;
    /* overflow-y: auto; */
    justify-content: space-between;
    border-bottom: 3px solid ${Common.color.p800};
    padding: 0 0 10px 0;
  }
  .title {
    font-size: 20px;
    font-weight: bold;
  }

  button {
    width: 22px;
    border: none;
    background-color: transparent;
  }
  .table {
    padding: 20px;
    position: relative;
    display: flex;
    gap: 50px;
    font-size: 13px;
    align-items: center;
    border-bottom: 1px solid ${Common.color.p800};
    .hr {
      font-weight: bold;
    }
  }
  .grade {
    padding: 20px;
    position: relative;
    display: flex;
    align-items: center;
    border-bottom: 1px solid ${Common.color.p800};
    gap: 10px;
    p {
      font-size: 20px;
      font-weight: bold;
    }
  }
  .input {
    padding-top: 20px;
    position: relative;
    display: flex;
    /* align-items: center; */
    border-bottom: 1px solid ${Common.color.p800};
  }
  .submit {
    padding-top: 20px;
    position: relative;
    display: flex;
    align-items: center;
    /* border-bottom: 1px solid ${Common.color.p800}; */
    /* background: ${Common.color.b900}; */
    justify-content: center;
    button {
      width: 120px;
      height: 40px;
      background: ${Common.color.b900};
      color: ${Common.color.p100};
      font-size: 13px;
      cursor: pointer;
    }
  }
`;

// ---------------------리뷰삭제 모달------------------------------------

export const ModalDeletWrap = styled.div`
  position: relative;
  min-width: 870px;
  height: 310px;
  background-color: ${Common.color.p100};
  padding: 20px;
  margin: 0 auto;
`;

export const SubmitBt = styled.div`
  padding-top: 20px;
  position: relative;
  display: flex;
  align-items: center;
  /* border-bottom: 1px solid ${Common.color.p800}; */
  /* background: ${Common.color.b900}; */
  justify-content: center;
  gap: 50px;
  button {
    width: 120px;
    height: 40px;
    background: ${Common.color.b900};
    color: ${Common.color.p100};
    font-size: 13px;
    cursor: pointer;
  }
`;
