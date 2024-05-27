import jwtAxios from "../util/jwtUtil";
import { SERVER_URL } from "./config";

export const buypage = async () => {
  try {
    const res = await jwtAxios.get(`${SERVER_URL}/user/info`);

    if(JSON.stringify(res.status).startsWith('2')){
        return res.data;
    }

  } catch (err) {
    console.log(err);
  }
};
