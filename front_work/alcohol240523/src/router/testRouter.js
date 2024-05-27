import { lazy, Suspense } from "react";
import { Navigate } from "react-router";

// 테스트페이지
const ListPage = lazy(() => import("../pages/product_test/ListPage"));

const testRouter = () => {
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
  ];
};

export default testRouter;
