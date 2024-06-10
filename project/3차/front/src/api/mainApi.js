import axios from "axios";
import { SERVER_URL } from "./config";

const prefix = `${SERVER_URL}/main`;

export const getMostProduct = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}/most`;
    const res = await axios.get(url);

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

export const getNewProduct = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}/newproduct`;
    const res = await axios.get(url);

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

export const getRandProduct = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}/rand`;
    const res = await axios.get(url);

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
