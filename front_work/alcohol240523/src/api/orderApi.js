import jwtAxios from "../util/jwtUtil";
import { SERVER_URL } from "./config";

const prefix = `${SERVER_URL}/purchase`;

export const getPickUp = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}/pickup`;
    const res = await jwtAxios.get(url);

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("메인 모스트 데이터 불러오기 실패");
    }
  } catch (error) {
    errorFn(error);
  }
};

export const getDelivery = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}/delivery`;
    const res = await jwtAxios.get(url);

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("메인 모스트 데이터 불러오기 실패");
    }
  } catch (error) {
    errorFn(error);
  }
};
