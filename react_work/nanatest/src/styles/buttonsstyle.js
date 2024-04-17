import styled from "@emotion/styled";

export const Buttons = styled.button`
  width: 144px;
  height: 57px;
  font-weight: 700;
  font-size: 20px;
  background: transparent;
  /* 뒤로가기 #868686 / 수정하기 #42B0FF / 삭제하기 #FF4E4E*/
  color: ${props => (props.gray ? "#868686" : props.txtColor)};
  /* 뒤로가기 #868686 / 수정하기 #42B0FF / 삭제하기 #FF4E4E*/
  border-color: ${props => (props.gray ? "#868686" : props.borderColor)};
  border: solid 1px;
`;
