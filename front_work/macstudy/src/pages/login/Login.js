import axios from "axios";

const Login = () => {
    const doLogin = async() => {
        const result = await axios.get('/test/token');
        console.log(result);
        if(result.status === 200){
            console.log('login success');
            localStorage.setItem('accessToken', result.data);
        }
    }
    return (<>
    <h1>Login</h1>
    <button onClick={doLogin}>로그인</button>
    </>  );
}
 
export default Login;