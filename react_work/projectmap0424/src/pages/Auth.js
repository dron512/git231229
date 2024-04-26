import axios from 'axios';

const code = new URL(window.location.href).searchParams.get("code");

const loginAxios = async () =>{
    await axios.get('http://localhost:8080/kakao/login', {
        headers: {
            'Content-Type' : 'application/json',
            'token' : code
        },
    }).then(res =>{
        console.log(res.data.access_token)
        localStorage.setItem("access_token",res.data.access_token)
    })
}

if(code !== null){
    loginAxios();
}

const Auth = () => {
    return ( 
        <>
            <h1>Auth</h1>
            <a href='/'>메인</a>
        </>
     );
}
 
export default Auth;