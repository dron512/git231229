import React from "react";

import { Outlet } from "react-router";
import ProductLayout from "./ProductLayout";

const ProductPage = () => {
  return (
    <div>
      <Outlet>
        <ProductLayout />
      </Outlet>
    </div>
  );
};

export default ProductPage;
