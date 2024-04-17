import axios, { Axios } from "axios";
import { API_SERVER_HOST } from "../../util/util";
import jwtAxios from "../../util/jwtUtil";

const prefix = `${API_SERVER_HOST}/api/product`;

// 해당 카테고리 분류 출력
// http://localhost:3000/api/product?imiddle=1&imain=0&sortBy=2&page=1
// http://192.168.0.144:5223/api/product?imiddle=0&imain=0&sortBy=2&page=1
export const getProductPage = async ({
  productParam,
  successFn,
  failFn,
  errorFn,
}) => {
  // console.log("getTodoIuser");
  // console.log("getProductPage");

  try {
    // console.log(productParam);
    // const res = await axios.get(query, { productParam });
    // const query = `${prefix}/productBySubcategory?sortBy=${productParam.sortBy}&대분류=${productParam.대분류}&중분류=${productParam.중분류}&페이지=${productParam.페이지}`;

    const url = `${prefix}`;
    // console.log("제품 호출 : ", ur l);
    // const res = jwtAxios.get(url, { params: productParam });
    const res = await axios.get(url, { params: productParam });
    // console.log(res);
    // console.log("목록 서버 데이터 :", res.data);
    const resStatus = res.status.toString();
    if (resStatus.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("잘못된 요청입니다.");
    }
  } catch (error) {
    const sampleData = [
      {
        iproduct: 9,
        productNm: "ac",
        price: 35482,
        rcFl: 1,
        popFl: 0,
        newFl: 0,
        reviewCnt: 0,
        likeProduct: 0,
        repPic: "사진",
      },
      {
        iproduct: 19,
        productNm: "aliquet",
        price: 43722,
        rcFl: 0,
        popFl: 0,
        newFl: 0,
        reviewCnt: 0,
        likeProduct: 0,
        repPic: "사진",
      },
      {
        iproduct: 25,
        productNm: "vivamus",
        price: 46900,
        rcFl: 0,
        popFl: 0,
        newFl: 1,
        reviewCnt: 0,
        likeProduct: 0,
        repPic: "사진",
      },
    ];
    errorFn(sampleData);
  }
};

export const putWish = async ({ iproduct, successFn, failFn, errorFn }) => {
  try {
    // http://192.168.0.144:5223/api/user/address?iaddress=45
    const url = `${prefix}/wish`;
    const res = await jwtAxios.put(url, { iproduct: iproduct });

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("제품삭제 호출 오류입니다.");
    }
  } catch (error) {
    errorFn(error);
  }
};

// // 찜 기능
// // http://192.168.0.144:5223/api/product/wish
// export const putWish = async ({ iproduct, successFn, failFn, errorFn }) => {
//   try {
//     const header = { headers: { "Content-Type": "application/json" } };
//     const body = { iproduct };
//     const res = await jwtAxios.put(`${host}/wish`, body);
//     const status = res.status.toString();
//     if (status.charAt(0) === "2") {
//       successFn(res.data);
//     } else {
//       failFn("목록 호출 오류입니다.");
//     }
//   } catch (error) {
//     errorFn("목록 호출 서버 에러에요", error);
//   }
// };
