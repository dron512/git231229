import { lazy, Suspense } from "react";
import { Navigate } from "react-router";
import { DeliveryPage, PickUpPage } from "../pages/pick/DeliveryCatePage";

const PickListPage = lazy(() => import("../pages/pick/PickListPage"));
const MyReviewPage = lazy(() => import("../pages/mypage/MyReview"));
const OrderPage = lazy(() => import("../pages/order/OrderPage"));
// const mymain = lazy(() => import("../pages/mypage/outlet/MyReview"));

const pickProductRouter = () => {
  return [
    { path: "", element: <Navigate to="" /> },

    {
      path: "pick",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <PickUpPage />
        </Suspense>
      ),
    },
    {
      path: "delivery",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <DeliveryPage />
        </Suspense>
      ),
    },
  ];
};

export default pickProductRouter;
