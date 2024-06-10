import { atom } from "recoil";
import { getCookie } from "../util/cookieUtil";

const initState = {
  // email: "",
  // password: "",
};
const loadMemberCookie = () => {
  const memberInfo = getCookie("member");
  return memberInfo;
};

export const atomSignState = atom({
  key: "atomSignState",
  default: loadMemberCookie() || initState,
});
