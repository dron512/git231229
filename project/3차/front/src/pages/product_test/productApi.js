import axios from "axios";

export const getData = async ({ mainCategory }) => {
  try {
    const response = await axios.post(`/search/maincategory`);
    if (response.status === 200) {
      return response.data;
    } else {
      console.log("problem");
    }
  } catch (error) {
    console.log(error);
  }
};
