import { lazy, Suspense } from "react";
import { Navigate } from "react-router";

// 결제 기본 페이지
const CheckoutPage = lazy(() => import("../pages/mypage/ReviewPage"));
// 성공하였을 때 페이지
const SuccessPage = lazy(() => import("../pages/mypage/MyMainPage"));
//  실패하였을 때 페이지
const FailPage = lazy(() => import("../pages/mypage/MyReview"));

const paymentRouter = () => {
  return [
    { path: "", element: <Navigate to="checkout" /> },
    {
      path: "checkout",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <CheckoutPage />
        </Suspense>
      ),
    },
    {
      path: "success",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <SuccessPage />
        </Suspense>
      ),
    },
    {
      path: "fail",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <FailPage />
        </Suspense>
      ),
    },
  ];
};

export default paymentRouter;
