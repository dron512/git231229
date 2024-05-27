import jwtAxios from "../util/jwtUtil";
import { SERVER_URL } from "./config";

const prefix = `${SERVER_URL}/review`;

export const getReviewList = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}/list`;
    const res = await jwtAxios.get(url);

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("메인 리뷰 데이터 불러오기 실패");
    }
  } catch (error) {
    errorFn(error);
  }
};

export const getReviewcheck = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}/check`;
    const res = await jwtAxios.get(url);

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("메인 리뷰 데이터 불러오기 실패");
    }
  } catch (error) {
    errorFn(error);
  }
};

export const postReviewcheck = async ({ successFn, failFn, errorFn }) => {
  try {
    const url = `${prefix}`;
    const res = await jwtAxios.get(url);

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("메인 리뷰등록 데이터 불러오기 실패");
    }
  } catch (error) {
    errorFn(error);
  }
};

export const postReviewcreate = async ({
  reivewParam,
  successFn,
  failFn,
  errorFn,
}) => {
  try {
    const url = `${prefix}`;

    const res = await jwtAxios.post(url, { ...reivewParam });

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      successFn(res.data);
    } else {
      failFn("메인 리뷰등록 데이터 불러오기 실패");
    }
  } catch (error) {
    errorFn(error);
  }
};

// export const deleteReview = async ({
//   reivewParam,
//   successFn,
//   failFn,
//   errorFn,
// }) => {
//   try {
//     const url = `${prefix}`;

//     const res = await jwtAxios.delete(url, { ...reivewParam });

//     const status = res.status.toString();
//     if (status.charAt(0) === "2") {
//       successFn(res.data);
//     } else {
//       failFn("메인 리뷰등록 데이터 불러오기 실패");
//     }
//   } catch (error) {
//     errorFn(error);
//   }
// };

export const deleteReview = async ({ code, successFn, failFn, errorFn }) => {
  try {
    // const url = `${prefix}?code=${code.code}`;
    const url = `${prefix}`;
    const res = await jwtAxios.delete(url, { data: { alcohol: code } });

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
