import { Button, Form, Input } from "antd";
import React from "react";

const initState = {
  email: "",
  pw: "",
};
const onFinish = values => {
  console.log("Success:", values);
};
const onFinishFailed = errorInfo => {
  console.log("Failed:", errorInfo);
};
const Log = () => {
  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "252px",
        maxWidth: "800px",
        margin: "0 auto",
      }}
    >
      <Form
        style={{
          width: "100%",
          maxWidth: 800,
        }}
        initialValues={{
          remember: true,
        }}
        onFinish={onFinish}
        onFinishFailed={onFinishFailed}
        autoComplete="off"
      >
        {/* 유저 아이디 style */}
        <Form.Item
          name="username"
          rules={[
            {
              required: true,
              message: "아이디를 입력해주세요!",
            },
          ]}
          // 유저 아이디 창 길이조절
          wrapperCol={{
            offset: 4,
            span: 16,
          }}
          style={{ height: "70px" }}
        >
          {/* 유저 아이디 인풋 스타일 */}
          <Input
            placeholder="아이디를 입력하세요."
            style={{
              height: "60px",
              fontSize: "20px",
              borderRadius: "0px",
              borderTop: "none",
              borderLeft: "none",
              borderRight: "none",
              outline: "none",
              boxShadow: "none",
            }}
          />
        </Form.Item>

        {/* 유저 패스워드 style */}
        <Form.Item
          name="password"
          rules={[
            {
              required: true,
              message: "비밀번호를 입력해주세요!",
            },
          ]}
          // 유저 패스워드 창 길이조절
          wrapperCol={{
            offset: 4,
            span: 16,
          }}
          style={{ height: "70px" }}
        >
          {/* 유저 패스워드 인풋 스타일 */}
          <Input.Password
            placeholder="비밀번호를 입력하세요."
            style={{
              height: "60px",
              fontSize: "20px",
              borderRadius: "0px",
              borderTop: "none",
              borderLeft: "none",
              borderRight: "none",
              outline: "none",
              boxShadow: "none",
            }}
          />
        </Form.Item>

        {/* 버튼 창 길이조절 */}
        <Form.Item
          wrapperCol={{
            offset: 4,
            span: 16,
          }}
        >
          {/* 버튼 style */}
          <Button
            type="primary"
            htmlType="submit"
            style={{
              width: "100%",
              height: "60px",
              background: "#E9B25F",
              fontSize: "25px",
            }}
          >
            로그인
          </Button>
        </Form.Item>
      </Form>
    </div>
  );
};

export default Log;
