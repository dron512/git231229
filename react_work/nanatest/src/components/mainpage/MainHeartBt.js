import React, { useState } from "react";
import { putWish } from "../../api/mainpage/mainPageApi";
import useCustomLogin from "../../hooks/useCustomLogin";
import { ModalButton, ModalPop, StyledButton } from "../../styles/mainstyle";
import styled from "styled-components";

const MainHeartBt = ({ item }) => {
  const [isHeartChecked, setHeartChecked] = useState(item.likeProduct === 1);
  const { isLogin, moveToPath } = useCustomLogin();
  const [isModal, setIsModal] = useState(false);

  const handleHeartButtonClick = async () => {
    const newValue = !isHeartChecked ? 1 : 0;
    setHeartChecked(!isHeartChecked);
    // console.log("제품 pk값 내놔 : ", item.iproduct);

    // console.log(newValue);

    try {
      // api.js에 정의된 updateLike 함수를 사용하여 서버에 데이터를 업데이트
      const response = await putWish({
        iproduct: item.iproduct,
        successFn,
        failFn,
        errorFn,
      });

      if (response !== undefined) {
        // console.log("하트업데이트 성공!", item.iproduct, response);
      } else {
        // console.error("putWish 함수에서 응답이 없습니다.");
      }
    } catch (error) {
      // console.error("하트업데이트 초오비사아아아앙", error);
    }
  };

  const successFn = result => {
    // console.log(result);
  };
  const failFn = result => {
    // console.log("하트 업데이트 실패: ", result);
  };
  const errorFn = result => {
    // console.log("하트 업데이트 에러: ", result);
  };

  // 로그인 유무 따져서 버튼 클릭 시 로그인 이동 모달창 또는 on/off 넣기

  const plzLogin = () => {
    // 모달 열기
    setIsModal(true);
  };
  const callFN = () => {
    moveToPath(`/login`);
    // 모달 닫기
    setIsModal(false);
  };

  return (
    <div>
      {isModal ? (
        <ModalPop>
          <div className="modalBack">
            <h1>로그인</h1>
            <div>
              찜목록은 로그인 후 이용이 가능하오니 나나빛 로그인 부탁드립니다.
            </div>
            <ModalButton>
              <button onClick={callFN}>로그인 바로가기</button>
            </ModalButton>
          </div>
        </ModalPop>
      ) : null}
      {isLogin ? (
        <StyledButton checked={isHeartChecked} onClick={handleHeartButtonClick}>
          <img
            src={
              isHeartChecked
                ? process.env.PUBLIC_URL + "/assets/images/heart.svg"
                : process.env.PUBLIC_URL + "/assets/images/heartoff.svg"
            }
            alt="heart"
            className="heart-icon"
          />
        </StyledButton>
      ) : (
        <StyledButton>
          <img
            src={process.env.PUBLIC_URL + "/assets/images/heartoff.svg"}
            alt="heart"
            className="heart-icon"
            onClick={plzLogin}
          />
        </StyledButton>
      )}
    </div>
  );
};

export default MainHeartBt;
