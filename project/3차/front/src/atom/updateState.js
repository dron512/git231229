import { atom } from "recoil";

export const reviewListState = atom({
  key: "reviewListState",
  default: [], // 초기값은 빈 배열
});
