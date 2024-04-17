import styled from "@emotion/styled";

export const ButtonContainer = styled.div`
  position: relative;
  width: 100px;
  height: 100px;
  text-align: center;
  align-items: center;
  justify-content: center;
  /* display: flex; */

  border-radius: 50px;
  left: 90%;
  box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.25);
`;

export const OpenModalButton = styled.button`
  border: none;
  background-color: transparent;
  font-size: 50px;
  /* padding-bottom: 10px; */
  margin-top: 20px;
  /* position: fixed; */
`;

export const CloseButton = styled.span`
  font-size: 24px;
  cursor: pointer;
  position: absolute;
  top: 10px;
  right: 10px;
  z-index: 1; /* Ensure the close button stays above other content */
`;

export const ModalOverlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 9999;
`;

export const MealWrap = styled.div`
  width: 608px;
  height: 680px;
  border-radius: 10px;
  background: #fff;
  box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.25);
  top: 50%;
  left: 50%;
  transform: translate(-100%, -5%);
  position: relative;
  z-index: 1000;
  display: block;
  /* position: fixed; */
`;

export const BabyMealInfo = styled.div`
  width: 100%;
  height: 100%;
  padding: 33px;
  display: flex;
  flex-direction: column;
`;

export const BaByMealTitle = styled.h2`
  color: #42b0ff;
  font-size: 30px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
  margin-bottom: 30px;
`;

export const BabyMealMonth = styled.h3`
  color: #5f5f5f;
  font-size: 15px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
  margin-bottom: 17px;
  text-align: left;
  white-space: pre-line;
`;

export const BabyMealDesc = styled.p`
  color: #5f5f5f;
  font-size: 15px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
  text-align: left;
  /* margin-bottom: 300px; */
`;
