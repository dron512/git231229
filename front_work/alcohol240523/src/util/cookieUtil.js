import { Cookies } from "react-cookie";

const cookie = new Cookies();

export const setCookie = (name, value, day = 1) => {
  const expires = new Date();
  expires.setUTCDate(expires.getUTCDate() + day);
  return cookie.set(name, value, { path: "/", expires: expires });
};

export const getCookie = name => {
  return cookie.get(name);
};

// removeCookie( 쿠키이름, 저장된 경로 기본값)
// 로그아웃시 정보 삭제
export const removeCookie = (name, path = "/") => {
  cookie.remove(name, { path });
};
