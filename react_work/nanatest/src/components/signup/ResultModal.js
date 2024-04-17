import React from "react";
import { motion } from "framer-motion";
// 타이틀, 내용, 확인버튼 클릭시 콜백 함수
const ResultModal = ({
  title,
  content,
  callFN,
  errorbt,
  errorbk,
  message,
  btchange,
  cancelFN,
}) => {
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
    borderRadius: "20px",
    zIndex: 999,
  };
  const popmodal = {
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    textAlign: "center",
    width: "500px",
    height: "300px",
    borderRadius: "20px",
    background: "#fff",
    gap: 15,
  };
  const poptitle = {
    color: "#4F95FF",
    fontFamily: "Noto Sans KR",
    fontSize: "60px",
    fontStyle: "normal",
    fontWeight: 700,
    lineHeight: "normal",
    ...errorbt,
  };
  const popcontent = {
    color: "#000",
    textAlign: "center",
    fontFamily: "Noto Sans KR",
    fontSize: "25px",
    fontStyle: "normal",
    fontWeight: 500,
    lineHeight: "normal",
    wordBreak: "pre-line",
  };
  const popbt = {
    width: "70px",
    height: "40px",
    fontFamily: "Noto Sans KR",
    fontSize: "15px",
    fontStyle: "normal",
    fontWeight: 700,
    lineHeight: "normal",
    color: "#FFF",
    border: "none",
    borderRadius: "5px",
    background: "#4F95FF",
    ...errorbk,
  };

  return (
    <div style={popstyle}>
      <motion.div
        initial={{ opacity: 0, y: 50 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.5 }}
        style={popmodal}
      >
        <div style={poptitle}>{title}</div>
        <div style={popcontent}>
          {content}
          {message}
        </div>
        <div>
          {btchange === false ? (
            <div style={{ display: "flex", justifyContent: "center", gap: 15 }}>
              <button onClick={cancelFN} style={popbt}>
                취소
              </button>
              <button onClick={callFN} style={popbt}>
                확인
              </button>
            </div>
          ) : (
            <button onClick={callFN} style={popbt}>
              창 닫기
            </button>
          )}
        </div>
      </motion.div>
    </div>
  );
};

export default ResultModal;
