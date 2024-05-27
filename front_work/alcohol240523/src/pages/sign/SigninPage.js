import { LockOutlined, UserOutlined } from "@ant-design/icons";
import { Button, Checkbox, Form, Input } from "antd";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { getKakaoLoginLink } from "../../api/kakaoApi";
import { postLogin } from "../../api/signUpApi";
import useCustomLogin from "../../hooks/useCustomLogin";
import { Common } from "../../styles/CommonCss";
import { LoginBt, LoginTitle, LoginWrap } from "../../styles/login/loginCss";

const initState = {
  email: "",
  password: "",
};
const LoginPage = () => {
  const navigate = useNavigate();
  const [loginParam, setLoginParam] = useState(initState);
  const kakaoLogin = getKakaoLoginLink();

  const handleChange = e => {
    // e.target.name
    // e.target.value
    loginParam[e.target.name] = e.target.value;
    setLoginParam({ ...loginParam });
  };
  // 커스터훅 사용하기
  const { doLogin, moveToPath } = useCustomLogin();
  const handleClick = () => {
    const kakaoURL = getKakaoLoginLink();
    window.location.href = kakaoURL;
  };
  const onFinish = async values => {
    try {
      // 로그인 요청
      const result = await postLogin({
        loginParam,
        successFn,
        failFn,
        errorFn: errorFn,
      });

      // 로그인 성공 시 처리
      successFn(result);

      // 로그인 후 작업 수행
      doLogin({ loginParam });
    } catch (error) {
      // 로그인 실패 시 처리
      failFn(error);
    }
  };
  const successFn = result => {
    console.log("토큰 - ", result);
    moveToPath("/");
  };

  const failFn = result => {
    console.log("실패", result);
    alert("이메일 및 비밀번호 확인하세요.");
  };

  const errorFn = result => {
    console.log("서버 에러", result);
  };

  return (
    <div>
      {/* {console.log("로그인인포", loginParam)} */}
      <LoginWrap>
        <LoginTitle>
          <p className="logo">ALCHOHOL HOLIC</p>
          <div className="email-line">
            <div className="line"></div>
            <p>이메일 로그인</p>
            <div className="line"></div>
          </div>
        </LoginTitle>
        <Form
          name="normal_login"
          className="login-form"
          initialValues={{
            remember: true,
            email: loginParam.email,
            password: loginParam.password,
          }}
          onFinish={onFinish}
        >
          <Form.Item
            name="email"
            rules={[
              {
                required: true,
                message: "이메일을 입력해 주세요!",
              },
            ]}
          >
            <Input
              prefix={<UserOutlined className="site-form-item-icon" />}
              placeholder="이메일"
              name="email"
              onChange={handleChange}
              style={{
                width: "100%",
                height: "60px",
                fontSize: "20px",
              }}
            />
          </Form.Item>
          <Form.Item
            name="password"
            rules={[
              {
                required: true,
                message: "비밀번호를 입력해 주세요!",
              },
            ]}
          >
            <Input.Password
              style={{
                width: "100%",
                height: "60px",
                fontSize: "20px",
              }}
              prefix={<LockOutlined className="site-form-item-icon" />}
              type="password"
              placeholder="비밀번호"
              name="password"
              onChange={handleChange}
            />
          </Form.Item>

          <Form.Item>
            <div
              style={{
                position: "relative",
                display: "flex",
                justifyContent: "space-between",
                width: "100%",
              }}
            >
              <Form.Item name="remember" valuePropName="checked" noStyle>
                <Checkbox>이메일 저장하기</Checkbox>
              </Form.Item>
              <a className="login-form-forgot" href="/sign/FindIdPw">
                아이디/ 비밀번호 찾기
              </a>
            </div>
          </Form.Item>

          {/* <Form.Item>
            <Button
              type="primary"
              htmlType="submit"
              className="login-form-button"
            >
              Log in
            </Button>
            Or <a href="">register now!</a>
          </Form.Item> */}
          <Form.Item>
            {/* 버튼 style */}
            <Button
              type="primary"
              htmlType="submit"
              style={{
                width: "100%",
                height: "60px",
                background: `${Common.color.f900}`,
                fontSize: "20px",
              }}
            >
              로그인
            </Button>
          </Form.Item>
        </Form>
        <LoginTitle>
          <div className="login-line">
            <div className="line"></div>
            <p>간편 로그인/회원가입</p>
            <div className="line"></div>
          </div>
        </LoginTitle>
        <LoginBt
          onClick={handleClick}
          style={{ background: `${Common.color.y900}`, border: "none" }}
        >
          <img
            src={process.env.PUBLIC_URL + "/images/kakao.png"} // 수정된 부분
            alt="heart"
          />
          카카오 3초만에 시작하기
        </LoginBt>
        <LoginBt
        onClick={()=>navigate('/sign/up')}
        >회원가입</LoginBt>
      </LoginWrap>
    </div>
  );
};

export default LoginPage;
