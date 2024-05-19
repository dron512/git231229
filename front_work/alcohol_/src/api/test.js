import Axios from 'axios';

export const doA = async () => {
  const res = await Axios.get("https://jsonplaceholder.typicode.com/posts");
  return res.data;
}

