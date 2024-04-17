import axios from "axios";
import { API_SERVER_HOST } from "../../util/util";
import jwtAxios from "../../util/jwtUtil";

const host = `${API_SERVER_HOST}/api/product`;

// 비로그인 추천상품 가져오기
// http://192.168.0.144:5223/api/product/main
export const getBeforeList = async ({ successFn, failFn, errorFn }) => {
  try {
    const res = await axios.get(`${host}/main`);
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

// 로그인 추천상품 가져오기
// http://192.168.0.144:5223/api/product/login-main
export const getAfterList = async ({ successFn, failFn, errorFn }) => {
  try {
    // const header = { headers: { "Content-Type": "application/json" } };
    const res = await jwtAxios.get(`${host}/login-main`);
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

// 인기상품과 신상품 가져오기
// http://192.168.0.144:5223/api/product/pop-new-product
export const getPoPNewList = async ({ successFn, failFn, errorFn }) => {
  try {
    // const header = { headers: { "Content-Type": "application/json" } };
    const res = await axios.get(`${host}/pop-new-product`);
    // const res = await jwtAxios.get(`${host}/main`, header);
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

// 찜 기능
// http://192.168.0.144:5223/api/product/wish
export const putWish = async ({ iproduct, successFn, failFn, errorFn }) => {
  try {
    const body = { iproduct };
    const res = await jwtAxios.put(`${host}/wish`, body);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data.result);
    } else {
      failFn("목록 호출 오류입니다.");
    }
  } catch (error) {
    errorFn("목록 호출 서버 에러에요", error);
  }
};
