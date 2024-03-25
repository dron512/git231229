function doLogin() {
    console.log('일로오나');
    // 로그인할 이메일과 비밀번호를 변수에 담는다
    const loginemail = document.getElementById("loginemail");
    const loginpassword = document.getElementById("loginpassword");
    // fetch("http://112.218.211.194:8888/user/signIn", {
        fetch("http://localhost:8080/user/signIn", {
            // method는 get, post, put, delete가 있다 
            // 백단과 맞게 적기 (노션참고)
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            // post매핑을 쓰기 때문에 바디로 보낸다
            // 이때 json형식으로 보내겠다는 뜻
            body: JSON.stringify(
                {
                    // 보낼 데이터가 들어갈 컬럼(컬럼명이 틀리면 안됨) : 보낼 데이터
                    email: loginemail.value,
                    password: loginpassword.value,
                }
            )
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("서버 오류 발생");
            }
            return response.text();
        })
        .then(data => {
            localStorage.setItem("token", data);
            console.log(data);
            alert("로그인 되었습니다");
            loginemail.value = "";
            loginpassword.value = "";
            location.href = 'main.html';
        })
        .catch(error => {
            console.error(error);
        });

}