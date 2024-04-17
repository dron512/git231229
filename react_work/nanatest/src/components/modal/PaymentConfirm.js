import React from "react";

const PaymentConfirm = (text, callFn) => {
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
        몸체
        <div>
          <div>
            <p>{text}</p>
          </div>
          <div>
            <button onClick={callFn}>네</button>
            <button>아니오</button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PaymentConfirm;
