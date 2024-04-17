import axios from "axios";
import jwtAxios from "../../util/jwtUtil";
import { API_SERVER_HOST } from "../../util/util";

const host = `${API_SERVER_HOST}/api/product`;

export const postSign = async ({ values, successFn, failFn, errFn }) => {
  // console.log(values);
  try {
    const res = await axios.post(`/api/user/sign-up`, { ...values });
    // console.log(res.data);
    const status = res.status.toString();
    const httpSt = status.charAt(0);
    if (httpSt === "2") {
      return successFn(res.data);
    }
  } catch (error) {
    // console.log(error);
    if (error.request.readyState === 4) {
      // console.log();
      return failFn();
    } else {
      errFn("서버에러에요");
    }
  }
};

export const getList = async () => {
  try {
    const res = await axios.get("/api/user/sign-up");
    // console.log(res);

    // HTTP 상태 코드 파악하기
    const status = res.status.toString();
    // 문자열 예) "200" 또는 "404" 의 0번 위치 글자를 알아낸다.
    const httpSt = status.charAt(0);
    if (httpSt === "2") {
      // console.log("성공");
      return res.data;
    } else {
      // console.log("실패");
      return "잘못된 정보를 전달함.";
    }
  } catch (error) {
    // console.log(error);
  }
};

export const postSignCheck = async ({
  userObject,
  successFnid,
  failFnid,
  errorFnid,
}) => {
  try {
    const res = await axios.post(`/api/user/sign-up/check-id`, userObject);
    // console.log(res);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFnid(res.data.result);
    } else if (status.charAt(0) === "4") {
      // console.log("히윽", res.data);
    }
  } catch (error) {
    console.log(error);
    if (error.request.readyState === 4) {
      console.log(error.response.data.validErrorList[0].message);
      return failFnid(error.response.data.validErrorList[0].message);
    } else {
      errorFnid("서버에러에요");
    }
  }
};

export const putModify = async ({ values, successFn, failFn, errorFn }) => {
  // console.log(values);
  try {
    const res = await jwtAxios.put(`/api/user/modify`, values);
    console.log(res);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("전송 오류입니다.");
    }
  } catch (error) {
    console.log(error);
    if (error.request.readyState === 4) {
      console.log(error.response.data.validErrorList[0].message);
      return failFn(error.response.data.validErrorList[0].message);
    } else {
      errorFn("서버에러에요");
    }
  }
};

export const postModify = async ({ values, successFn, failFn, errorFn }) => {
  console.log(values);
  try {
    const res = await jwtAxios.post(`/api/user/modify`, values);
    console.log(res);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("전송 오류입니다.");
      // console.log("히윽");
    }
  } catch (error) {
    errorFn(error.response.data.message);
  }
};

export const deleteModify = async ({ successPro, failPro, errorPro, aaa }) => {
  try {
    const res = await jwtAxios.delete(`/api/user/modify`);
    console.log(res.data.result);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successPro(res.data);
    } else {
      failPro("전송 오류입니다.");
      console.log("히윽");
    }
  } catch (error) {
    errorPro("서버에러에요");
  }
};

export const getProduct = async (iproduct, param) => {
  try {
    const res = await axios.get(`/api/product/${iproduct}`, {
      params: { ...param },
    });
    console.log(iproduct);
    console.log(res);
    const status = res.status.toString();
    const httpSt = status.charAt(0);
    if (httpSt === "2") {
      return res.data;
    } else {
      return "잘못된 정보를 전달함.";
    }
  } catch (error) {
    console.log(error);
  }
};

export const postOrder = async ({
  productOrder,
  successFn,
  failFn,
  errorFn,
}) => {
  console.log(productOrder);
  try {
    const res = await jwtAxios.post(`/api/order`, productOrder);
    console.log(res);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("히윽");
    }
  } catch (error) {
    // 오류 처리 함수 호출 시 오류 메시지 전달
    errorFn("서버에러에요");
  }
};

export const getPayItemList = async () => {
  try {
    const res = await jwtAxios.get(`api/order/confirm?iorder=100025`);
    console.log("asdsadsa", res);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      console.log("!@!@!@!@", res);
    }
  } catch (error) {
    console.log("목록 호출 서버 에러에요", error);
  }
};

export const postCart = async cart => {
  try {
    const res = await jwtAxios.post(`/api/product/cart`, cart);
    console.log(res);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      return res.data;
    } else {
      console.log("히윽");
    }
  } catch (error) {
    // 오류 처리 함수 호출 시 오류 메시지 전달
    console.log("서버에러에요");
  }
};

export const putWish = async item => {
  try {
    const header = { headers: { "Content-Type": "application/json" } };

    const res = await jwtAxios.put(`/api/product/wish`, item);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      return res.data.result;
    } else {
      console.log("목록 호출 오류입니다.");
    }
  } catch (error) {
    console.log("목록 호출 서버 에러에요", error);
  }
};
