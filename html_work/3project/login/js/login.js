function doLogin() {
    const loginemail = document.getElementById("loginemail");
    const loginpassword = document.getElementById("loginpassword");
    // fetch("http://112.218.211.194:8888/user/signIn", {
        fetch("http://112.218.211.194:10049/user/signIn", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(
                {
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
            alert('로그인실패');
            console.error(error);
        });

}