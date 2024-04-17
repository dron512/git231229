import { Cookies } from "react-cookie";
// 사용법은 정말 단순
const cookie = new Cookies();

// 외부에서 사용하기 위해서 export 한다.
// setCookie( 쿠키이름, 저장할 값, 유통기한 시간기본 - 1일)
// 로그인시 정보 저장
export const setCookie = (nm, value, day = 1) => {
  // 날짜(유통기간)을 생성
  const expires = new Date();
  expires.setUTCDate(expires.getUTCDate() + day);
  return cookie.set(nm, value, { path: "/", expires: expires });
};

// getCookie( 쿠키이름)
// 로그인된 정보 필요시
export const getCookie = name => {
  return cookie.get(name);
};

// removeCookie( 쿠키이름, 저장된 경로 기본값)
// 로그아웃시 정보 삭제
export const removeCookie = (name, path = "/") => {
  cookie.remove(name, { path });
};
