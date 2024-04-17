import axios from "axios";
import { API_SERVER_HOST } from "../../util/util";
import jwtAxios from "../../util/jwtUtil";
const host = `${API_SERVER_HOST}/api/order`;
// 구매할 목록 가져오기
// http://192.168.0.144:5223/api/order/confirm?iorder=1
export const getPayItemList = async ({
  iorder,
  successFn,
  failFn,
  errorFn,
}) => {
  try {
    const res = await jwtAxios.get(`${host}/confirm?iorder=${iorder}`);
    // console.log("페이먼트에이피아이", res.data);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res);
    } else {
      failFn("목록 호출 오류입니다.");
    }
  } catch (error) {
    errorFn("목록 호출 서버 에러에요", error);
  }
};
// 결제완료 페이지로 넘기기
// http://192.168.0.144:5223/api/order
export const putOrderPage = async ({
  formData,
  successFn,
  failFn,
  errorFn,
}) => {
  try {
    const res = await jwtAxios.put(`${host}`, { ...formData });
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
      // console.log();
    } else {
      failFn();
    }
  } catch (error) {
    errorFn(error);
  }
};
