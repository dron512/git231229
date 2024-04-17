import React, { Suspense, lazy } from "react";

import { Navigate, Route, Routes } from "react-router-dom";
import { Wrap } from "./styles/basic";
import LoginPage from "./pages/LoginPage";
import CartPage from "./pages/cartpage/CartPage";
import CommunityPage from "./pages/community/CommunityPage";
import ErrorPage from "./pages/errorPage/ErrorPage";
import DetailPage from "./pages/itemPage/ItemPage";
// import MainPage from "./pages/mainPage/MainPage";
import MonthlyPage from "./pages/monthlyPage/MonthlyPage";
import MyPage from "./pages/myPage/MyPage";
import OrderCompletePage from "./pages/orderComplete/OrderCompletePage";
import OrderList from "./pages/orderList/OrderListPage";
import PaymentPage from "./pages/paymentPage/PaymentPage";
import ReviewPage from "./pages/reviewPage/ReviewPage";

import ItemPage from "./pages/signup/ItemPage";
import Signup from "./pages/signup/Signup";

import CommuAdd from "./pages/community/communiys/CommuAdd";
import CommuEdit from "./pages/community/communiys/CommuEdit";
import CommuRead from "./pages/community/communiys/CommuRead";
import NoticePage from "./pages/community/communiys/NoticePage";

import BasicLayout from "./layouts/BasicLayout";
import ModifyPages from "./pages/signup/ModifyPages";
import ProductPage from "./pages/product/ProductPage";
import SerchPage from "./pages/serch/SerchPage";
import AddressInfo from "./pages/address/AddressInfo";
import AddressAdd from "./pages/address/AddressAdd";
import AddressModify from "./pages/address/AddressModify";
import MainPage from "./pages/mainPage/MainPage";
import ReviewAddPage from "./pages/reviewPage/ReviewAddPage";

import useCustomLogin from "./hooks/useCustomLogin";

import ProductLayout from "./pages/product/ProductLayout";
import ModifyPw from "./pages/signup/ModifyPw";
import ToyProduct from "./pages/product/ToyProduct";
import MealProduct from "./pages/product/MealProduct";
import BreastfeedingProduct from "./pages/product/BreastfeedingProduct";
import AppliancesProduct from "./pages/product/AppliancesProduct";
import CleanProduct from "./pages/product/CleanProduct";
import Loading from "./components/loading/Loading";

const LazyTodoOrderListPage = lazy(() =>
  import("./pages/orderList/OrderListPage"),
);
const App = () => {
  const { isLogin, loginState, doLogout, moveToPath } = useCustomLogin();
  return (
    <Wrap>
      <BasicLayout>
        <Routes>
          {/* <Route path="*" element={<h1>파일이없네요.</h1>}></Route> */}
          {/* <Route path="/intro" element={<Intro />}></Route> */}
          {/* <Route path="/" element={<BasicLayout />}></Route> */}
          <Route path="/" element={<MainPage />}></Route>

          <Route path="/login" element={<LoginPage />}></Route>

          {isLogin ? <Route path="/cart" element={<CartPage />}></Route> : null}
          {/*게시판 */}
          <Route path="/commu/" element={<CommunityPage />}>
            <Route index element={<Navigate to="list" />}></Route>
            {/* 커뮤니티 */}
            <Route path="list" element={<NoticePage />} />
            {/* 등록 */}
            <Route path="add" element={<CommuAdd />} />
            {/* 수정 */}
            <Route path="modify/:id" element={<CommuEdit />} />
            {/* 읽기 */}
            <Route path="read/:id" element={<CommuRead />} />
          </Route>

          <Route path="/product/" element={<ProductPage />}>
            {/* <Route path="meal" element={<ProductLayout />} /> */}
            <Route path="meal" element={<MealProduct />} />
            <Route path="Appliances" element={<AppliancesProduct />} />
            <Route path="toy" element={<ToyProduct />} />
            <Route path="clean" element={<CleanProduct />} />
            <Route path="breast" element={<BreastfeedingProduct />} />
          </Route>

          <Route path="/detail" element={<DetailPage />}></Route>

          <Route path="/monthly" element={<MonthlyPage />}></Route>
          {isLogin ? <Route path="/mypage" element={<MyPage />}></Route> : null}

          <Route path="/order/:iorder" element={<OrderCompletePage />}></Route>

          <Route
            path="/orderList"
            element={
              <Suspense fallback={<Loading />}>
                <LazyTodoOrderListPage />
              </Suspense>
            }
          ></Route>

          <Route path="/payment" element={<PaymentPage />}></Route>

          <Route path="/ol" element={<OrderList />}></Route>
          <Route path="/payment/:iorder" element={<PaymentPage />}></Route>

          <Route path="/review" element={<ReviewPage />}></Route>
          <Route
            path="/reviewadd/:iproduct/:idetails/:iorder"
            element={<ReviewAddPage />}
          ></Route>
          <Route path="/signup" element={<Signup />}></Route>
          <Route path="/modify/:id" element={<ModifyPages />}></Route>
          <Route path="/modifypw" element={<ModifyPw />}></Route>
          <Route path="/item/:iproduct" element={<ItemPage />}></Route>
          <Route path="/cc" element={<SerchPage />}></Route>

          {isLogin ? (
            <Route path="/address/" element={<AddressInfo />}></Route>
          ) : null}
          {isLogin ? (
            <Route path="/address/add" element={<AddressAdd />}></Route>
          ) : null}
          {isLogin ? (
            <Route path="/address/modify" element={<AddressModify />}></Route>
          ) : null}

          <Route path="*" element={<ErrorPage />}></Route>
        </Routes>
      </BasicLayout>
    </Wrap>
  );
};

export default App;
