import { Button, Form, Input } from "antd";
import React, { useState } from "react";
import useCustomLogin from "../hooks/useCustomLogin";
import useCustomMove from "../hooks/useCustomMove";
import {
  LoginBox,
  LoginBtArea,
  LoginFooter,
  LoginHeader,
  LoginMain,
  LoginPageBt,
  LoginPageWrap,
} from "../styles/loginpage/loginpagestyle";
import { useDispatch } from "react-redux";
import ResultModal from "../components/signup/ResultModal";

const LoginPage = () => {
  const { moveToSignUp } = useCustomMove();
  const { doLogin, moveToPath } = useCustomLogin();
  const [resultTitle, setResultTitle] = useState("");
  const [resultContent, setResultContent] = useState("");
  const [reDirect, setReDirect] = useState(0);
  const [modalStyle, setModalStyle] = useState({});
  const [modalStyleBk, setModalStyleBk] = useState({});

  const successFn = result => {
    setModalStyle({});
    setModalStyleBk({});
    setResultTitle("로그인 성공");
    setResultContent("로그인에 성공하였습니다.");
    setReDirect(0);
    // console.log(result);
  };
  const failFn = result => {
    setResultTitle("로그인 실패");
    setResultContent("아이디와 비밀번호를 다시 확인해주세요.");
    setReDirect(1);
    console.log(result);
  };
  const errorFn = error => {
    if (error.response.status === 404) {
      // alert("오류임 뭔가");
      setModalStyle({ color: "red" });
      setModalStyleBk({ background: "red" });
      setResultTitle("로그인 실패");
    }
    // setResultContent(result);
    setReDirect(1);
    // console.log(result);
  };

  const closeModal = () => {
    // 팝업닫기
    setResultTitle("");
    setResultContent("");

    if (reDirect === 0) {
      // 목록가기
      // navigate(`/modify`);
      // console.log(serverResult);
      // moveToMain();
      moveToPath("/");
    } else {
      // 팝업닫기
    }
  };

  // 초기값
  const initState = {
    uid: "",
    upw: "",
  };

  const [loginParam, setLoginParam] = useState(initState);
  // 커스텀 훅 사용하기

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

  return (
    <>
      <LoginPageWrap>
        {resultTitle && (
          <ResultModal
            title={resultTitle}
            content={resultContent}
            callFN={closeModal}
            errorbt={modalStyle}
            errorbk={modalStyleBk}
          />
        )}
        <LoginHeader />

        <LoginMain>
          <LoginBox>
            <img src={process.env.PUBLIC_URL + "/assets/images/logo.svg"} />
          </LoginBox>
          {/* // 전체 로그인 폼 */}
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
              label={
                <label style={{ color: "#E9B25F", fontSize: "20px" }}>ID</label>
              }
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
              label={
                <label style={{ color: "#E9B25F", fontSize: "20px" }}>PW</label>
              }
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
          <LoginBtArea>
            <LoginPageBt onClick={() => moveToSignUp()}>
              <h1>아직 계정이 없으신가요?</h1>
              <h3>회원가입 바로가기</h3>
            </LoginPageBt>
          </LoginBtArea>
        </LoginMain>
        <LoginFooter>
          <h2>COPYRIGHT @ 나나빛 브랜드 공식몰 ALL RIGHTS RESERVED.</h2>
        </LoginFooter>
      </LoginPageWrap>
    </>
  );
};

export default LoginPage;
