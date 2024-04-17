import React from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import "./App.css";
import { CheckoutPage } from "./Checkout.jsx";
import { SuccessPage } from "./Success.jsx";
import { FailPage } from "./Fail.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    // 결제요청
    element: <CheckoutPage />,
  },
  {
    path: "success",
    // 결제성공
    element: <SuccessPage />,
  },
  {
    path: "fail",
    // 결제실패
    element: <FailPage />,
  },
]);

export function App() {
  return <RouterProvider router={router} />;
}
