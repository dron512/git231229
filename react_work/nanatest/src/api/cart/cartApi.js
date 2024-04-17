import jwtAxios from "../../util/jwtUtil";
import { API_SERVER_HOST } from "../../util/util";

const host = `${API_SERVER_HOST}/api/product/cart`;

// 제품 목록가져오기
export const getCart = async ({ successFn, failFn, errorFn }) => {
  try {
    const res = await jwtAxios.get(host);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("목록 호출 오류입니다.");
    }
  } catch (error) {
    errorFn("목록 호출 서버 에러에요");
  }
};

// 제품 삭제하기
export const deleteCart = async ({ iproduct, successFn, failFn, errorFn }) => {
  try {
    const res = await jwtAxios.delete(`${host}?iproduct=${iproduct}`);

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else if (status.charAt(0) === "4") {
      failFn("니가 잘못함");
    } else {
      failFn("제품삭제 호출 오류입니다.");
    }
  } catch (error) {
    errorFn(error);
  }
};

// 제품 수정하기
export const patchCart = async ({
  iproduct,
  productCnt,
  successFn,
  failFn,
  errorFn,
}) => {
  try {
    const res = await jwtAxios.patch(
      `${host}?iproduct=${iproduct}&productCnt=${productCnt}`,
      { productCnt, iproduct },
    );
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("상세정보 호출 오류입니다.");
    }
  } catch (error) {
    errorFn(error);
  }
};

// 파일 업로드 비동기 통신

export const postCart = async ({
  products,
  totalOrderPrice,
  successFn,
  failFn,
  errorFn,
}) => {
  try {
    // {zipCode: "12", address: "12", addressDetail: "12"}
    // {detailedAddress: '12', address: '부산 기장군 장안읍 좌해로 14', zipCode: '46033'}
    const res = await jwtAxios.post(`${API_SERVER_HOST}/api/order`, {
      products,
      totalOrderPrice,
    });
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("전송 오류입니다.");
    }
  } catch (error) {
    errorFn("서버에러에요");
  }
};
