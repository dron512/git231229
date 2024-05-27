import axios from "axios";
import jwtAxios from "../util/jwtUtil";
import { SERVER_URL } from "./config";

const prefix = `${SERVER_URL}/main`;

export const postMainCate = async ({
  values,
  address,
  withdrawStatus,
  successFn,
  failFn,
  errFn,
}) => {
  try {
    const url = `${prefix}/main`;
    const res = await axios.post(url, {
      ...values,
      address: address,
      withdrawStatus: withdrawStatus, // 추가 정보 전달
    });
    const status = res.status.toString();
    const httpSt = status.charAt(0);
    if (httpSt === "2") {
      return successFn(res.data);
    }
  } catch (error) {
    if (error.request.readyState === 4) {
      return failFn();
    } else {
      errFn("서버에러에요");
    }
  }
};

// Final
export const getAlcholType = async (mainCategory, subCategory) => {
  // console.log("m-axios  :", mainCategory);
  // console.log("s-axios  :", subCategory);
  let category;
  if (subCategory !== "") {
    category = subCategory;
  } else {
    category = mainCategory;
  }
  try {
    const response = await axios.get(
      `${SERVER_URL}/search/category?category=${category}`,
    );
    if (response.status === 200) {
      // console.log("data :", response.data);
      return response.data;
    } else {
      console.log("no");
    }
  } catch (error) {
    console.log(error);
  }
};

export const nonSignAlcholSearch = async ( {search} ) => {
  console.log("axios-data", search);
  try {
    console.log('여기오나')
    const response = await axios.post(
      `${SERVER_URL}/main/anony/contents`,
      search,
    );
    console.log(response.status)
    if (response.status === 200) {
      console.log("result", response.data);
      const result = response.data;
      return result;
    } else {
      console.log("no");
    }
  } catch (error) {
    alert(error.response.data.errorMessage)
  }
};

// export const nonSignAlcholSearch = async ( search ) => {
//   console.log("axios-data", search);
//   const searchCon = {
//     searchcontents: search
//   }
//     await axios.post(
//       `${SERVER_URL}/main/anony/contents`,
//       searchCon,
//     ).then(res =>{
//         console.log(res.data)
//     })
// };
// export const SignAlcholSearch = async () => {};

export const SignAlcholSearch = async ({ search }) => {
  try {
    const response = await jwtAxios.post(`${SERVER_URL}/main/contents`, search);
    if (response.status === 200) {
      // console.log("result", response.data);
      const result = response.data;
      return result;
    } else {
      console.log("no");
    }
  } catch (error) {
    console.log(error);
  }
};

export const getDetail = async ({ code }) => {
  console.log("axios", code);
  const codeParam = {
    code: Number(code),
  };
  console.log("params  ", codeParam);
  try {
    const response = await jwtAxios.post(`${SERVER_URL}/detail`, codeParam);
    if (response.status === 200) {
      console.log("R : ", response.data);
      return response.data;
    } else {
      console.log("no");
    }
  } catch (error) {
    console.log(error);
  }
};

export const getRecent = async () => {
  try {
    const response = await axios.get(`${SERVER_URL}/main/recnet`);
    if (response.status === 200) {
      console.log("결과값 : ", response.data);
      return response.data;
    }
  } catch (error) {
    console.log(error);
  }
};
export const getUserRecent = async () => {
  try {
    const response = await jwtAxios.get(`${SERVER_URL}/main/recent`);
    if (response.status === 200) {
      console.log("결과값 : ", response.data);
      return response.data;
    }
  } catch (error) {
    console.log(error);
  }
};

export const getMarketPath = async ({ code }) => {
  console.log("ax:", code);
  const postcode = {
    code: code,
  };
  try {
    const response = await jwtAxios.post(
      `${SERVER_URL}/detail/market`,
      postcode,
    );
    if (response.status === 200) {
      return response.data;
    }
  } catch (error) {
    console.log(error);
  }
};

export const postAddCart = async ({ postcard }) => {
  console.log("ax :", postcard);
  try {
    const response = await jwtAxios.post(
      `${SERVER_URL}/shoppingbasket`,
      postcard,
    );
    if (response.status === 200) {
      console.log("result :", response.data);
      return response.data;
    }
  } catch (error) {
    console.log(error);
  }
};
