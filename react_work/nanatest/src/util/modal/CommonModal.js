import React, { useState } from "react";
import ResultModal from "../../components/signup/ResultModal";
import useCustomMove from "../../hooks/useCustomMove";

  // 팝업창 내용
  const [popTitle, setPopTitle] = useState();
  const [popContent, setPopContent] = useState();
  // 창을 닫은 경우 어디로 이동할지를 결정
  // 목록으로 가거나 아니면 그냥 수정창 상태로 두거나
  const [reDirect, setRedirect] = useState(0);
  // 안내창이 열릴지 말지 결정하는 상태
  const [result, setResult] = useState(false);

  const { moveToList, moveToRead } = useCustomMove();

  // 0이면 1이면 창닫기
  const closeModal = () => {
    setResult(false);
    if (reDirect === 0) {
      // 목록으로 : 페이지 상태 유지하면서 이동
      moveToList({ page: 1 });
    } else if (reDirect === 2) {
      // 읽기로 페이지 이동
      moveToRead(tno);
    }
  };


const CommonModal = () => {
  return (
    <div>
      <ResultModal />
    </div>
  );
};

export default CommonModal;
