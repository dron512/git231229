import React from "react";
import { Outlet } from "react-router-dom";
import BasicLayout from "../../layout/BasicLayout";

const ProductPage = () => {
  return (
    <BasicLayout>
      <Outlet />
    </BasicLayout>
  );
};

export default ProductPage;
