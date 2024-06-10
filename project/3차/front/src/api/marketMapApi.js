import axios from "axios";
import { SERVER_URL } from "./config";

const prefix = `${SERVER_URL}/market`;

export const getMarketAddress = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}/address`;
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
