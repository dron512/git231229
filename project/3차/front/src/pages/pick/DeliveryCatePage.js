import React from "react";
import ProductPickPage from "./PickListPage";
import { getDeliveryProduct, getPickProduct } from "../../api/pickProductApi";

const DeliveryPage = () => {
  return (
    <ProductPickPage titleTest="배달 & 배송" apiFunction={getDeliveryProduct} />
  );
};

const PickUpPage = () => {
  return <ProductPickPage titleTest="매장픽업" apiFunction={getPickProduct} />;
};

export { DeliveryPage, PickUpPage };
