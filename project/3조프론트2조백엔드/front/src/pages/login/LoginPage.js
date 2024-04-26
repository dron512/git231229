import { LockOutlined, UserOutlined } from "@ant-design/icons";
import styled from "@emotion/styled/macro";
import { Button, Checkbox, Flex, Form, Input } from "antd";
import React from "react";
import { Common } from "../../styles/CommonCss";
import { useNavigate } from "react-router-dom";
import { LoginBt, LoginTitle, LoginWrap } from "../../styles/login/loginCss";
import useCustomMove from "../../hooks/useCustomMove";

const LoginPage = () => {
  const navigate = useNavigate();
  const moveToMain = useCustomMove();
  const onFinish = values => {
    console.log("Received values of form: ", values);
  };

  return (
    <div>
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
          }}
          onFinish={onFinish}
        >
          <Form.Item
            name="username"
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
              <a className="login-form-forgot" href="">
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
          onClick={() => moveToMain()}
          style={{ background: `${Common.color.y900}`, border: "none" }}
        >
          <img
            src={process.env.PUBLIC_URL + "/images/kakao.png"} // 수정된 부분
            alt="heart"
          />
          카카오 3초만에 시작하기
        </LoginBt>
        <LoginBt onClick={() => navigate(`/`)}>이메일로 가입하기</LoginBt>
      </LoginWrap>
    </div>
  );
};

export default LoginPage;
