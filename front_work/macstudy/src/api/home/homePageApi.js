import axios from 'axios';


export const getLottoNumber = async () => {
    const fetchData = async() => {
        const result = await axios.get('/test/test');
        console.log(result.status);
        console.log(result.data);
    }
    fetchData();

};