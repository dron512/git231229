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
const SignFindIdPwPage = () => {
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
            <p>아이디 찾기</p>
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
            <p>비밀번호찾기</p>
            <div className="line"></div>
          </div>
        </LoginTitle>
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
            name="phone"
            rules={[
              {
                required: true,
                message: "핸드폰번호를 입력해주세요",
              },
            ]}
          >
            <Input.Password
              style={{
                width: "100%",
                height: "60px",
                fontSize: "20px",
              }}
              prefix={<UserOutlined className="site-form-item-icon" />}
              type="text"
              placeholder="핸드폰번호"
              name="phone"
              onChange={handleChange}
            />
          </Form.Item>
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
            비밀번호 찾기
          </Button>
      </LoginWrap>
    </div>
  );
};

export default SignFindIdPwPage;
