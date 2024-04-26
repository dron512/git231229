import axios from "axios";

const Rest_api_key = "94b443da7db84c565579d43ba563dd3f"; //REST API KEY
const redirect_uri = "http://localhost:3000/auth"; //Redirect URI

// oauth 요청 URL
const kakaoURL = `https://kauth.kakao.com/oauth/authorize?client_id=${Rest_api_key}&redirect_uri=${redirect_uri}&response_type=code`;
const handleLogin = () => {
  window.location.href = kakaoURL;
};

var tokenValue = '';
const login = () => {

  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;

  const body = {
      email: email,
      password: password
  }

  axios.post('http://localhost:8080/login',body)
  .then(res =>{
    console.log(res.data)
    if(res.status.toString().startsWith('2')){
      tokenValue = res.data
    }
  }).catch(error => console.log(error.response.data))
}


const userInfo = async () =>{
  const token = document.getElementById('token').value;
   await axios.post('http://localhost:8080/valid',null,{
        headers:{
            'Authorization': 'Bearer ' + tokenValue
        }
    }).then(res =>{
        
        console.log(res)
    })
}

const Login = () => {
  return (
    <>
      <h1>Login</h1>
      <h2>Email <input id='email' type='text'></input></h2>
      <h2>Password <input id='password' type='password'></input></h2>
      <button className='kakao-login'  onClick={login}>로그인</button>
      <button className="kakao-login" onClick={handleLogin}>
        카카오 로그인
      </button>
      <h1>토큰확인</h1>
      <h2>Token <input id='token' type='text'></input></h2>
      <button onClick={userInfo}>토큰확인</button>
    </>
  );
};

export default Login;
