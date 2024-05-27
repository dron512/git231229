import axios from "axios";

const code = new URL(window.location.href).searchParams.get("code");

const Rest_api_key = "94b443da7db84c565579d43ba563dd3f";
const LOGOUT_REDIRECT_URI = "http://localhost:3000/sign/kakao/logout";

const loginAxios = async () => {
  await axios
    .get("http://localhost:8080/kakao/login", {
      headers: {
        "Content-Type": "application/json",
        token: code,
      },
    })
    .then(res => {
      localStorage.setItem("access_token", res.data.access_token);
      localStorage.setItem("refresh_token", res.data.refresh_token);
      document.getElementById("access").innerText =
        "AccessToken = " + res.data.access_token;
      document.getElementById("refresh").innerText =
        "RefreshToken = " + res.data.refresh_token;
    })
    .catch(err => {
      console.log(err);
    });
};

const kakaoURLout = `https://kauth.kakao.com/oauth/logout?client_id=${Rest_api_key}&logout_redirect_uri=${LOGOUT_REDIRECT_URI}`;
const handleLogout = () => {
    console.log('여기오나')
  if (
    localStorage.getItem("access_token") !== "undefined" &&
    localStorage.getItem("access_token") !== null
  ) {
    window.location.href = kakaoURLout;
  }
};

if (code !== null) {
  loginAxios();
}

const SigninkakaoPage = () => {
  return (
    <div>
      <h1 id="access"></h1>
      <h1 id="refresh"></h1>
      <button style={{width:'300px', height: '50px',fontSize:'2rem'}} onClick={handleLogout}>카카오 로그아웃</button>
    </div>
  );
};

export default SigninkakaoPage;
