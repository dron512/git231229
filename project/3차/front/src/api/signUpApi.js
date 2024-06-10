import axios from "axios";
import { SERVER_URL } from "./config";
import jwtAxios from "../util/jwtUtil";
import Swal from 'sweetalert2';

// const prefix = `${API_SERVER_HOST}/login/create`;
const prefix = `${SERVER_URL}`;

export const postSign = async ({
  values,
  address,
  withdrawStatus,
  emailch,
  authNum,
  successFn,
  failFn,
  errFn,
}) => {
  try {
    const url = `${prefix}/login/create`;
    if(values.gender === null || values.gender === ""){
      return Swal.fire('성별을 선택해 주세요.')
    }
    if(values.email === emailch.email && authNum === JSON.stringify(emailch.auth)){
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
    }
    else{
      Swal.fire("인증번호 혹은 인증한 이메일과 같은 이메일인지 확인해 주세요.")
    }
    
  } catch (error) {
    if (error.request.readyState === 4) {
      return failFn(error.response.data);
    } else {
      errFn("서버에러에요");
    }
  }
};

// export const postLogin = async ({ values, successFn, failFn, errFn }) => {
//   try {
//     const url = `${prefix}/login`;
//     const res = await axios.post(url, {
//       ...values,
//     });
//     const status = res.status.toString();
//     const httpSt = status.charAt(0);
//     if (httpSt === "2") {
//       return successFn(res.data);
//     }
//   } catch (error) {
//     if (error.request.readyState === 4) {
//       return failFn();
//     } else {
//       errFn("서버에러에요");
//     }
//   }
// };

// export const postLogin = async ({ loginParam, successFn, failFn, errorFn }) => {
//   try {
//     // 만약에 API 서버가 JSON 을 원한다면
//     const header = { headers: { "Content-Type": "application/json" } };
//     const formData = new FormData();
//     // formData.append("이름", "값")
//     formData.append("uid", loginParam.uid);
//     formData.append("upw", loginParam.password);
//     const url = `${prefix}/login`;
//     const res = await axios.post(url, loginParam, header);

//     const status = res.status.toString();

//     if (status.charAt(0) === "2") {
//       // 화면 처리용
//       successFn(res.data);

//       // RTK 업데이트 하기위해서는 리턴을 해서 값을 전달해야 해
//       return res.data;
//     } else {
//       failFn("로그인에 실패하였습니다. 다시 시도해주세요.");
//     }
//   } catch (error) {
//     console.error("Error in loginPost:", error);
//     // 에러를 처리하는 함수 호출
//     // errorFn(error);
//   }
// };

export const postLogin = async ({ loginParam }) => {
  // try {
    // 만약에 API 서버가 JSON 을 원한다면
    const header = { headers: { "Content-Type": "application/json" } };

    const formData = new FormData();
    // formData.append("이름", "값")
    formData.append("username", loginParam.email);
    formData.append("password", loginParam.pw);
    const url = `${prefix}/login`;
    const res = await axios.post(url, loginParam, header);
    // const res = await axios.post(`${host}/login`, formData, header);
    return res.data;
    // const status = res.status.toString();

    // if (status.charAt(0) === "2") {
    //   // 화면 처리용
    //   successFn(res.data);

    //   // RTK 업데이트 하기위해서는 리턴을 해서 값을 전달해야 해
    //   return res.data;
    // } else {
    //   failFn("로그인에 실패하였습니다. 다시 시도해주세요.");
    // }
  // } catch (error) {
  //   console.log(
  //     "로그인에 실패하였습니다. 서버가 불안정합니다.다시 시도해주세요.",
  //   );
  // }
};
