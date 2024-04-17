import React from "react";
import { Buttons } from "../../styles/buttonsstyle";

const DefaultButton = ({ txt, txtColor, borderColor, type, aa, bb }) => {
  return (
    <div>
      <Buttons
        type={type}
        onClick={aa}
        onSubmit={bb}
        style={{ color: txtColor, borderColor: borderColor }}
      >
        {txt}
      </Buttons>
    </div>
  );
};
// 예제 파일
// <DefaultButton txt="뒤로가기" txtColor="gray" borderColor="gray" />
// <DefaultButton txt="수정하기" txtColor="#42B0FF" borderColor="#42B0FF" />
// <DefaultButton txt="삭제하기" txtColor="#FF4E4E" borderColor="#FF4E4E" />

export default DefaultButton;
