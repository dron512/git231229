import React from "react";
import { Route, Routes } from "react-router-dom";
import { Wrap } from "./styles/basic";
import Intro from "./pages/intro/Intro";
import BasicLayout from "./layout/BasicLayout";
import Main from "./pages/main/Main";
import ProductPage from "./pages/product/ProductPage";
import LoginPage from "./pages/login/LoginPage";
import MyPage from "./pages/mypage/MyPage";
import MyMainPage from "./pages/mypage/outlet/MyMainPage";
import ReviewPage from "./pages/mypage/outlet/ReviewPage";
import CreateReview from "./pages/mypage/outlet/CreateReview";
import DetailedItemPage from "./pages/item/DetailedItemPage";
import { getSearchName, locinCheck } from "./jwt/jwtAxios";
import SignupPage from "./pages/login/SignupPage";
import { RecoilRoot } from "recoil";
import CartPage from "./pages/cart/CartPage";
import PaymentPage from "./pages/payment/PaymentPage";
import OrderPage from "./pages/order/OrderPage";

const App = () => {
  // const listdata = await getSearchName();
  // console.log(listdata);

  return (
    <Wrap maxw={1920}>
      <BasicLayout>
        <Routes>
          <Route path="/" element={<Main />}></Route>
          <Route path="/product" element={<ProductPage />}></Route>
          <Route path="/login" element={<LoginPage />}></Route>
          <Route path="/singup" element={<SignupPage />}></Route>
          <Route path="/cart" element={<CartPage />}></Route>
          <Route path="/pay" element={<PaymentPage />}></Route>

          {/* 마이페이지 */}
          <Route path="/mypage/" element={<MyPage />}>
            <Route path="mymain" element={<MyMainPage />}></Route>
            <Route path="review" element={<ReviewPage />}></Route>
            <Route path="order" element={<OrderPage />}></Route>
            <Route path="createReview" element={<CreateReview />}></Route>
          </Route>

          <Route path="/item" element={<DetailedItemPage />}></Route>
          <Route path="/intro" element={<Intro />}></Route>
          <Route path="*" element={<h1>파일이없네요.</h1>}></Route>
        </Routes>
      </BasicLayout>
    </Wrap>
  );
};

export default App;
