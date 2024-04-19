import axios from 'axios';

const jwtAxios = axios.create();

const beforeReq = config => {
    const memberInfo = localStorage.getItem("memberInfo");
    if (!memberInfo) {
      return Promise.reject({ response: { data: { error: "Login 하세요." } } });
    }
    const { accessToken } = JSON.parse(memberInfo);
    config.headers.Authorization = `Bearer ${accessToken}`;
    return config;
  };

jwtAxios.interceptors.request.use(beforeReq);

export default jwtAxios;