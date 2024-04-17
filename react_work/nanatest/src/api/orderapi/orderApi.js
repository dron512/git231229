import jwtAxios from "../../util/jwtUtil";
import { API_SERVER_HOST } from "../../util/util";

// http://192.168.0.144:5223/api/order/100004
const host = `${API_SERVER_HOST}/api/order`;

export const getOCPage = async ({ iorder, successFn, failFn, errorFn }) => {
  try {
    const header = { headers: { "Content-Type": "application/json" } };
    // 파라메터는 JWT 인증으로 해결할 것이다.
    const res = await jwtAxios.get(`${host}/${iorder}`, header);
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
