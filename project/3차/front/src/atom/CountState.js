import { atom } from "recoil";
import { PCartData } from "../mock/CartData";

const initialCartCount = PCartData.reduce((acc, current) => {
  acc[current.key] = current.count;
  return acc;
}, {});

export const cartCountState = atom({
  key: "cartCountState",
  default: initialCartCount,
});
