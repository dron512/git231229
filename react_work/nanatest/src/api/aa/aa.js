import axios from "axios";

export const aa = async ({ setData }) => {
    try {
        const result = await axios.post("http://localhost:8080/api/aa", {
            'Content-Type': 'application/json',
            'Authorization':'Bearer '+localStorage.getItem('token')
        });
        setData(result);

    }
    catch(error){
        console.log(error);
    }
  };