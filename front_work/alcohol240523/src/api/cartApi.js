import jwtAxios from "../util/jwtUtil";
import { SERVER_URL } from "./config";

export const getCart = async () => {
  try {
    const response = await jwtAxios.get(`${SERVER_URL}/shoppingbasket`);
    if (response.status === 200) {
      return response.data;
    } else {
      console.log("no");
    }
  } catch (error) {
    console.log(error);
  }
};
