import { Button, Form, Input } from "antd";
import React, { useState } from "react";
import { useDispatch } from "react-redux";
import useCustomLogin from "../../hooks/useCustomLogin";

const LoginForm = (successFn, failFn, errorFn) => {
  // 초기값
  const initState = {
    uid: "",
    upw: "",
  };

  const [loginParam, setLoginParam] = useState(initState);
  // 커스텀 훅 사용하기
  const { doLogin, moveToPath } = useCustomLogin();

  const onFinish = values => {
    // console.log("Success:", values);
    doLogin({ loginParam, successFn, failFn, errorFn });
  };
  const onFinishFailed = errorInfo => {
    // console.log("Failed:", errorInfo);
  };

  // slice 값(state)을 읽을때        useSelector
  // slice 값(state)를 업데이트할때  useDispatch()
  const dispatch = useDispatch();

  const onValuesChanged = (changedValues, allValues) => {
    // console.log(_필드값);
    // console.log(_전체값);
    setLoginParam({ ...allValues });
  };

  // 전체 로그인 폼 style
  return (
    <Form
      style={{
        width: "540px",
        maxWidth: 800,
        height: "252px",
        margin: "0  auto  74px auto",
      }}
      initialValues={{
        remember: true,
        uid: loginParam.uid,
        upw: loginParam.upw,
      }}
      onValuesChange={(changedValues, allValues) => {
        onValuesChanged(changedValues, allValues);
      }}
      onFinish={onFinish}
      onFinishFailed={onFinishFailed}
      autoComplete="off"
      layout="vertical"
      requiredMark={false}
    >
      {/* 유저 아이디 style */}
      <Form.Item
        name="uid"
        label={<label style={{ color: "#E9B25F", fontSize: "20px" }}>ID</label>}
        rules={[
          {
            required: true,
            message: "아이디를 입력해주세요!",
            whitespace: true,
          },
        ]}
        style={{ height: "80px" }}
      >
        {/* 유저 아이디 인풋 스타일 */}
        <Input
          placeholder="아이디를 입력하세요."
          style={{
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
        name="upw"
        label={<label style={{ color: "#E9B25F", fontSize: "20px" }}>PW</label>}
        rules={[
          {
            required: true,
            message: "비밀번호를 입력해주세요!",
          },
        ]}
        style={{ height: "80px" }}
      >
        {/* 유저 패스워드 인풋 스타일 */}
        <Input.Password
          placeholder="비밀번호를 입력하세요."
          style={{
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
      <Form.Item>
        {/* 버튼 style */}
        <Button
          type="primary"
          htmlType="submit"
          style={{
            width: "540px",
            height: "60px",
            background: "#E9B25F",
            fontSize: "25px",
          }}
        >
          로그인
        </Button>
      </Form.Item>
    </Form>
  );
};
export default LoginForm;
