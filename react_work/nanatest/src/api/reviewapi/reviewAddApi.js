import jwtAxios from "../../util/jwtUtil";
import { API_SERVER_HOST } from "../../util/util";

const host = `${API_SERVER_HOST}/api/review`;

// 리뷰 작성하기
// /api/review/33
// /api/review/54
// {
//   "reviewPics": [
//     "string"
//   ],
//   "dto": {
//     "idetails": 0,
//     "iorder": 0,
//     "contents": "string",
//     "productScore": 5
//   }
// }
export const postReviewList = async (
  iproduct,
  { paramData, successFn, failFn, errorFn },
) => {
  try {
    const header = { headers: { "Content-Type": "multipart/form-data" } };
    const res = await jwtAxios.post(`${host}/${iproduct}`, paramData, header);

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("목록 호출 오류입니다.");
    }
  } catch (error) {
    errorFn("목록 호출 서버 에러에요", error);
  }
};

export const getProductReview = async (
  iproduct,
  param,
  { successFn, failFn, errorFn },
) => {
  try {
    const res = await jwtAxios.get(`/api/product/${iproduct}?page=${param}`, {
      params: { ...param },
    });
    const status = res.status.toString();
    const httpSt = status.charAt(0);
    if (httpSt === "2") {
      successFn(res.data);
    } else {
      failFn("잘못된 정보를 전달함.");
    }
  } catch (error) {
    errorFn(error);
  }
};
