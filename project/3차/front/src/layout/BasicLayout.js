import React from "react";
import BasicHeader from "./BasicHeader";
import BasicFooter from "./BasicFooter";

const BasicLayout = ({ children }) => {
  const MainStyle = {
    width: "130rem",
    margin: "0 auto",
  };
  return (
    <div className="wrap">
      <header>
        <BasicHeader />
      </header>

      <main style={MainStyle}>{children}</main>
      <footer>
        <BasicFooter />
      </footer>
    </div>
  );
};

export default BasicLayout;
