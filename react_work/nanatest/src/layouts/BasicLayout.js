import React from "react";

import BasicHeader from "./basic/BasicHeader";
import BasicFooter from "./basic/BasicFooter";
import Test from "./basic/Test";

// 객체 구조 분해 할당
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
