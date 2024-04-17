import { css } from "@emotion/react";
import styled from "@emotion/styled";

export const TextArea = styled.div`
  text-align: center;
  height: 80px;
  width: 100%;
  margin-top: 60px;
  margin-bottom: 50px;
  span {
    font-size: 20px;
    color: #595959;
  }
  i {
    font-size: 40px;
    color: #d68000;
    font-weight: 800;
    font-style: normal;
  }
`;

export const ItemPacket = styled.div`
  position: relative;
  display: block;
  width: 230px;
  height: 330px;
`;
export const ItemImg = styled.div`
  width: 230px;
  height: 230px;
  img {
    object-fit: cover;
    width: 230px;
    height: 230px;
  }
  &:hover {
    cursor: pointer;
  }
`;

export const ItemDecArea = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 230px;
  margin-top: 8px;
  &:hover {
    cursor: pointer;
  }
`;

export const ItemTagBoxDiv = styled.div`
  display: flex;
  align-items: center;
  gap: 5px;
  &:hover {
    cursor: pointer;
  }
`;

export const ReviewWish = styled.div`
  display: flex;
  /* flex-wrap: wrap; */
  gap: 5px;
  text-align: center;
  font-size: 15px;
  height: 25px;
  align-items: center;
  justify-content: center;
`;
export const StyledButton = styled.button`
  width: 14px;
  height: 14px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: none;
  border: none;
  cursor: pointer;

  img {
    width: 100%;
    height: 100%;
    object-fit: cover;

    filter: ${({ checked }) => (checked ? "none" : "grayscale(100%)")};
  }
`;
export const ItemTitlePrice = styled.div`
  width: 230px;
  margin-top: 3px;
  text-align: start;
  p {
    width: 230px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    font-size: 18px;
    color: #595959;
    line-height: 20px;
  }
  b {
    font-size: 30px;
    line-height: 33 px;
  }
`;

export const RcSwiperWrap = styled.div`
  position: relative;
  display: flex;
  justify-content: center;
  overflow: hidden;
  margin: 0 auto;
  width: 1440px;
  height: 330px;

  .slotWidthSett {
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .slide-prev-bt.swiper-button-disabled {
    display: none !important;
  }
  .slide-next-bt.swiper-button-disabled {
    display: none !important;
  }
  .slide-prev-bt {
    position: absolute;
    left: -3%;
    top: 40%;
    z-index: 2;
    /* 내용물만 옮겨준다. */
    transform: translate(-50%, -50%);
    border-radius: 50%;

    width: 48px;
    height: 48px;
    background-color: transparent;

    border: none;
    cursor: pointer;
  }
  .slide-prev-bt img {
    transform: rotate(180deg);
  }
  .slide-next-bt {
    position: absolute;
    right: -3%;
    top: 40%;
    z-index: 2;
    transform: translate(50%, -50%);
    border-radius: 50%;

    width: 48px;
    height: 48px;
    background-color: transparent;

    border: none;

    cursor: pointer;
  }
`;
export const SwiperDiv = styled.div`
  position: relative;
  display: block;
  height: 500px;
  .slide-prev-bt.swiper-button-disabled {
    display: none !important;
  }
  .slide-next-bt.swiper-button-disabled {
    display: none !important;
  }
  .slide-prev-bt {
    position: absolute;
    left: 4%;
    top: 50%;
    z-index: 2;
    /* 내용물만 옮겨준다. */
    transform: translate(-50%, -50%);

    width: 48px;
    height: 48px;
    background-color: rgba(255, 255, 255, 1);
    border: 1px solid #e3e2e3;
    border-radius: 50%;
    box-shadow: 0 0 0.8rem rgba(0, 0, 0, 0.13);
    cursor: pointer;
  }
  .slide-prev-bt img {
    transform: rotate(180deg);
  }
  .slide-next-bt {
    position: absolute;
    right: 4%;
    top: 50%;
    z-index: 2;
    transform: translate(50%, -50%);

    width: 48px;
    height: 48px;
    background-color: rgba(255, 255, 255, 1);
    border: 1px solid #e3e2e3;
    border-radius: 50%;
    box-shadow: 0 0 0.8rem rgba(0, 0, 0, 0.13);
    cursor: pointer;
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
    justify-content: center;
    text-align: center;
    background-color: white;
    width: 200px;
    height: 210px;
    border-radius: 10px;
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
    cursor: pointer;
  }
`;
