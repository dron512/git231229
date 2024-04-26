import axios from 'axios';

const Create = () => {
    const createUser = () =>{
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const passwordch = document.getElementById('passwordch').value;
        const nickname = document.getElementById('nickname').value;
        const birthdate = document.getElementById('birthdate').value;
        const gender = document.getElementById('gender').value;
        const phone = document.getElementById('phone').value;
        const address = document.getElementById('address').value;
        const lastaddress = document.getElementById('lastaddress').value;

        const body = {
            email: email,
            password: password,
            passwordch: passwordch,
            nickname: nickname,
            birthdate: birthdate,
            gender: gender,
            phone: phone,
            address: address,
            lastaddress: lastaddress
        }
        axios.post('http://localhost:8080/login/create',body,{
            
        }).then(res => {
            console.log(res)
        }).catch(error => console.log(error.response.data))
    }

    return ( 
        <>
        <h2>이메일 <input id='email' type='email'></input></h2>
        <h2>비밀번호 <input id='password' type='password'></input></h2>
        <h2>비밀번호 확인 <input id='passwordch' type='password'></input></h2>
        <h2>닉네임 <input id='nickname' type='text'></input></h2>
        <h2>생년월일 <input id='birthdate' type='text'></input></h2>
        <h2>성별 <select id='gender'><option value="MALE">남자</option><option value="FEMALE">여자</option></select></h2>
        <h2>휴대폰번호 <input id='phone' type='text'></input></h2>
        <h2>주소 <input id='address' type='text'></input></h2>
        <h2>상세주소 <input id='lastaddress' type='text'></input></h2>
        <button onClick={createUser}>회원가입</button>
        </>
     );
}
 
export default Create;