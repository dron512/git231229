import { lazy, Suspense } from "react";
import { createBrowserRouter } from "react-router-dom";
import mypageRouter from "./mypageRouter";
import paymentRouter from "./paymentRouter";
import signRouter from "./signRouter";
import productRouter from "./productRouter";
import directPayRouter from "./directPayRouter";
import testRouter from "./testRouter";
import pickProductRouter from "./pickProductRouter";
import Loading from "../components/common/Loading";

// Main-Page
const MainPage = lazy(() => import("../pages/main/Main"));
// Sign-Page
const SignPage = lazy(() => import("../pages/sign/SignPage"));
// Product-Page
const ProductPage = lazy(() => import("../pages/product/ProductPage"));
// Pick-Page
const PickPage = lazy(() => import("../pages/pick/PickPage"));
// Cart-Page
const CartPage = lazy(() => import("../pages/cart/CartPage"));
// Payment-Page
const PaymentPage = lazy(() => import("../pages/payment/PaymentPage"));
// My-Page
const MyPage = lazy(() => import("../pages/mypage/MyPage"));
// Map-Page
const StoreMapPage = lazy(() => import("../pages/storemap/StoreMapPage"));
// NotFound-Page
const NotFoundPage = lazy(() => import("../pages/storemap/StoreMapPage"));
// direcyPay-Page
const DirectPayPage = lazy(() => import("../pages/directpay/DirectPayPage"));
// Product-test
const TestPage = lazy(() => import("../pages/product_test/ProductTest"));

const router = createBrowserRouter([
  {
    path: "/",
    element: (
      <Suspense fallback={<div>Loading</div>}>
        <MainPage />
      </Suspense>
    ),
  },
  {
    path: "/sign/",
    element: (
      <Suspense fallback={<div>Loading</div>}>
        <SignPage />
      </Suspense>
    ),
    children: signRouter(),
  },
  {
    path: "/product/",
    element: (
      <Suspense
        fallback={
          <div>
            <Loading />
          </div>
        }
      >
        <ProductPage />
      </Suspense>
    ),
    children: productRouter(),
  },
  {
    path: "/pick/",
    element: (
      <Suspense fallback={<div>Loading</div>}>
        <PickPage />
      </Suspense>
    ),
    children: pickProductRouter(),
  },
  {
    path: "/cart",
    element: (
      <Suspense fallback={<div>Loading</div>}>
        <CartPage />
      </Suspense>
    ),
  },
  {
    path: "/payment/",
    element: (
      <Suspense fallback={<div>Loading</div>}>
        <PaymentPage />
      </Suspense>
    ),
    children: paymentRouter(),
  },
  {
    path: "/mypage/",
    element: (
      <Suspense fallback={<div>Loading</div>}>
        <MyPage />
      </Suspense>
    ),
    children: mypageRouter(),
  },
  {
    path: "/storemap/",
    element: (
      <Suspense fallback={<div>Loading</div>}>
        <StoreMapPage />
      </Suspense>
    ),
  },
  {
    path: "/directpay/",
    element: (
      <Suspense fallback={<div>Loading</div>}>
        <DirectPayPage />
      </Suspense>
    ),
    children: directPayRouter(),
  },
  // Product-test-router
  {
    path: "/test/",
    element: (
      <Suspense fallback={<div>Loading</div>}>
        <TestPage />
      </Suspense>
    ),
    children: testRouter(),
  },
  {
    path: "*",
    element: (
      <Suspense fallback={<div>Loading</div>}>
        <NotFoundPage />
      </Suspense>
    ),
  },
]);

export default router;
