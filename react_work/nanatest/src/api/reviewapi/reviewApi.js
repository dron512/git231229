import jwtAxios from "../../util/jwtUtil";
import { API_SERVER_HOST } from "../../util/util";

const host = `${API_SERVER_HOST}/api/review`;

// 리뷰 목록 가져오기
// http://112.222.157.156:5223/api/review?page=1
export const getReviewList = async ({ param, successFn, failFn, errorFn }) => {
  try {
    const res = await jwtAxios.get(`${host}`, { params: param });

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

// 리뷰 목록 삭제하기
// http://192.168.0.144:5223/api/review?ireview=8
export const deleteReviewList = async ({
  reviewData,
  successFn,
  failFn,
  errorFn,
}) => {
  try {
    const res = await jwtAxios.delete(`${host}?ireview=${reviewData}`);

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
