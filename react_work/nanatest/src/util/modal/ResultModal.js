import React from "react";
// 타이틀, 내용, 확인버튼 클릭시 콜백 함수
const ResultModal = ({ title, content, callFN }) => {
  const popstyle = {
    position: "fixed",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    left: 0,
    top: 0,
    width: "100%",
    height: "100%",
    background: "rgba(0,0,0,0.7)",
    zIndex: 999,
  };
  return (
    <div style={popstyle}>
      <div style={{ background: "#fff", textAlign: "center" }}>
        <div>{title}</div>
        <div>{content}</div>
        <div>
          <button onClick={callFN}>창 닫기</button>
        </div>
      </div>
    </div>
  );
};

export default ResultModal;
