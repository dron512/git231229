import React from "react";
import { Outlet } from "react-router-dom";
import BasicLayout from "../../layout/BasicLayout";

const SignPage = () => {
  return (
    <BasicLayout>
      <Outlet />
    </BasicLayout>
  );
};

export default SignPage;
