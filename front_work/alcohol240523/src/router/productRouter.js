import { lazy, Suspense } from "react";
import { Navigate } from "react-router";

// 로그인 페이지
const ListPage = lazy(() => import("../pages/product/ProductListPage"));

// 로그아웃 페이지
const DetailPage = lazy(() => import("../pages/product/ProductDetailPage"));

const productRouter = () => {
  return [
    { path: "", element: <Navigate to="list" /> },
    {
      path: "list",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <ListPage />
        </Suspense>
      ),
    },
    {
      path: "detail/:code",
      element: (
        <Suspense fallback={<div>Load..</div>}>
          <DetailPage />
        </Suspense>
      ),
    },
  ];
};

export default productRouter;
