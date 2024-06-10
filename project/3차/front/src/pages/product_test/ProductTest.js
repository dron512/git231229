import React from "react";
import { Outlet } from "react-router-dom";
import BasicLayout from "../../layout/BasicLayout";

const ProductTest = () => {
  return (
    <BasicLayout>
      <Outlet />
    </BasicLayout>
  );
};

export default ProductTest;
