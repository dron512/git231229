import axios from "axios";
import { SERVER_URL } from "./config";
import jwtAxios from "../util/jwtUtil";

const prefix = `${SERVER_URL}/favorites`;

export const getWishList = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}/list`;
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

export const deleteWish = async ({ code, successFn, failFn, errorFn }) => {
  try {
    // const url = `${prefix}?code=${code.code}`;
    const url = `${prefix}`;
    const res = await jwtAxios.delete(url, { data: { code: code.code } });

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

export const postWish = async ({ code, successFn, failFn, errorFn }) => {
  try {
    // const url = `${prefix}?code=${code.code}`;
    const url = `${prefix}`;
    const res = await jwtAxios.post(url, code);

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
