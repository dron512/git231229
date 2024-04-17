import jwtAxios from "../../util/jwtUtil";
import { API_SERVER_HOST } from "../../util/util";

const host = `${API_SERVER_HOST}/api/user/address`;

// 제품 목록가져오기
export const getAddress = async ({ successFn, failFn, errorFn }) => {
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

// 파일 업로드 비동기 통신

export const postAddress = async ({ values, successFn, failFn, errorFn }) => {
  try {
    // console.log("들어갔니?");
    // {zipCode: "12", address: "12", addressDetail: "12"}
    // {detailedAddress: '12', address: '부산 기장군 장안읍 좌해로 14', zipCode: '46033'}
    const res = await jwtAxios.post(`${host}`, { ...values });
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

// 제품 수정하기
export const putAdress = async ({
  iaddress,
  values,
  successFn,
  failFn,
  errorFn,
}) => {
  try {
    // 여기서도 이미지가 추가될 수 있어요
    // header 가 필요합니다.
    const header = { headers: { "Content-Type": "application/json" } };
    // console.log("여기는 되니?");
    const res = await jwtAxios.put(
      `${host}`,
      { ...values, iaddress },

      header,
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

// 제품 삭제하기
export const deleteOne = async ({ iaddress, successFn, failFn, errorFn }) => {
  try {
    // http://192.168.0.144:5223/api/user/address?iaddress=45
    // http://192.168.0.144:5223/api/product/cart?iproduct=1&iproduct=2&iproduct=3
    const res = await jwtAxios.delete(`${host}?iaddress=${iaddress}`);

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("제품삭제 호출 오류입니다.");
    }
  } catch (error) {
    errorFn(error);
  }
};
//
