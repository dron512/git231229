import jwtAxios from '../jwtAxios/jwtAxios';

export const getLottoNumber = async () => {
    const fetchData = async() => {
        const result = await jwtAxios.get('/test/test');
        console.log(result.status);
        console.log(result.data);
    }
    fetchData();

};