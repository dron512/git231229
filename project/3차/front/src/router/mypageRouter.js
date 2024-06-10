import { lazy, Suspense } from "react";
import { Navigate } from "react-router";

const PasswordCh = lazy(() => import("../pages/mypage/PasswordCh"));
const SignOutPage = lazy(() => import("../pages/mypage/SignOutPage"));

const ReviewPage = lazy(() => import("../pages/mypage/ReviewPage"));
const MyMainPage = lazy(() => import("../pages/mypage/MyMainPage"));
const MyReviewPage = lazy(() => import("../pages/mypage/MyReview"));
const OrderPage = lazy(() => import("../pages/order/OrderPage"));
const WishListPage = lazy(() => import("../pages/mypage/WishListPage"));
// const mymain = lazy(() => import("../pages/mypage/outlet/MyReview"));

const mypageRouter = () => {
  return [
    { path: "", element: <Navigate to="info" /> },
    {
      path: "info",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <MyMainPage />
        </Suspense>
      ),
    },
    {
      path: "signout",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <SignOutPage />
        </Suspense>
      ),
    },
    {
      path: "passwordCh",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <PasswordCh />
        </Suspense>
      ),
    },
    {
      path: "createreview",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <MyReviewPage />
        </Suspense>
      ),
    },
    {
      path: "review",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <ReviewPage />
        </Suspense>
      ),
    },
    {
      path: "order",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <OrderPage />
        </Suspense>
      ),
    },
    {
      path: "wish",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <WishListPage />
        </Suspense>
      ),
    },
  ];
};

export default mypageRouter;
