import axios from "axios";
import { SERVER_URL } from "./config";

SERVER_URL;

const rest_api_key = "94b443da7db84c565579d43ba563dd3f";
const redirect_uri = "http://localhost:3000/sign/kakao";
const auth_code_path = "https://kauth.kakao.com/oauth/authorize";

export const getKakaoLoginLink = () => {
  const kakaoURL = `${auth_code_path}?client_id=${rest_api_key}&redirect_uri=${redirect_uri}&response_type=code`;
  return kakaoURL;
};

const access_token_url = `https://kauth.kakao.com/oauth/token`;
export const getAccessToken = async authCode => {
  const header = {
    headers: {
      "Content-Type": "application/x-www-form-urlencoded;charset=utf-8",
    },
  };

  const params = {
    grant_type: "authorization_code",
    client_id: rest_api_key,
    redirect_uri: redirect_uri,
    code: authCode,
  };

  const res = await axios.post(access_token_url, params, header);

  const accessToken = res.data.access_token;

  return accessToken;
};

export const getMemberWithAccessToken = async accessToken => {
  console.log("백엔드에 회원 등록을 위한 액세스 토큰 전달 ", accessToken);
  const res = await axios.get(
    `${SERVER_URL}/api/member/kakao?accessToken=${accessToken}`,
  );

  return res.data;
};
