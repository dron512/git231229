import React from "react";
import BasicHeader from "./BasicHeader";
import BasicFooter from "./BasicFooter";

const BasicLayout = ({ children }) => {
  return (
    <div className="wrap">
      <header>
        <BasicHeader />
      </header>

      <main>{children}</main>
      <footer>
        <BasicFooter />
      </footer>
    </div>
  );
};

export default BasicLayout;
