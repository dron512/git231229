import React from "react";
import { Outlet } from "react-router-dom";
import BasicLayout from "../../layout/BasicLayout";

const PickPage = () => {
  return (
    <BasicLayout>
      <Outlet />
    </BasicLayout>
  );
};

export default PickPage;
