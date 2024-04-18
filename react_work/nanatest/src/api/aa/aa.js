import axios from "axios";

export const aa = async ({ setData }) => {
    try {
        const result = await axios.post("http://localhost:8080/api/aa", {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        });
        setData(result);

    }
    catch (error) {
        console.log(error);
    }
}
export const aa2 = async ({ sucessDataA, sucessDataB }) => {
    try {
        // const result = await axios.post("http://localhost:8080/api/aa", {
        //     'Content-Type': 'application/json',
        //     'Authorization':'Bearer '+localStorage.getItem('token')
        // });
        sucessDataA("바뀜");
        sucessDataB("바뀜asdfknasldkfjn");
    }
    catch (error) {
        console.log(error);
    }
};