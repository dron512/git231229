import axios from "axios";
import { SERVER_URL } from "./config";
import jwtAxios from "../util/jwtUtil";

const prefix = `${SERVER_URL}/main`;

export const getPickProduct = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}/pickup`;
    const res = await jwtAxios.get(url);

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("픽업매장 데이터 불러오기 실패");
    }
  } catch (error) {
    errorFn(error);
  }
};

export const getDeliveryProduct = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}/delivery`;
    const res = await jwtAxios.get(url);

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("픽업매장 데이터 불러오기 실패");
    }
  } catch (error) {
    errorFn(error);
  }
};
