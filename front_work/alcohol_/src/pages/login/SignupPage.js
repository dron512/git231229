import axios from "axios";
import React, { useState } from "react";

import { Button, Form, Input, Select } from "antd";
import { LoginTitle, LoginWrap, MyDiv } from "../../styles/login/loginCss";
import { Common, PMH } from "../../styles/CommonCss";
import { areaStyle, buttonPrimaryStyle } from "../../styles/sign/signArea";
import { P20, SignWrap } from "../../styles/basic";

import Address from "../../components/singup/Address";

import { useNavigate } from "react-router";

const initState = {
  name:"내이름뭐해",
  nicname: "홍길동",
  birth: "19850511",
  phoneNumber: "99462662",
  email: "bbb@naver.com",
  password: "1234",
  address: "대구 달서구 한들로 55",
};
const SignupPage = () => {
  const navigate = useNavigate();

  const [address, setAddress] = useState("");
  const [memberInfo, setMemberInfo] = useState(initState);

  const updateAddressInfo = ({ address }) => {
    setAddress(address);
  };

  const onFinish = async values => {
    try {
      const formData = {
        id : values.email,
        name: values.name,
        nicname: values.nicname,
        birth: values.birth,
        phone: values.phoneNumber,
        email: values.email,
        password: values.password,
        address: address, 
      };
      console.log("formData:", formData);
      const response = await axios.post("/auth/signUp", formData);
      console.log("회원가입 결과:", response);

      // 페이지이동
      if(response.status === 200) {
        navigate("/login");
      }
      // navigate("/login");
      const responseData = response.data;
    } catch (error) {
      // 데이터 전송 중 오류 발생 시 처리
      console.error("회원가입 오류:", error);
    }
  };

  const handleClickSearch = e => {
    e.preventDefault();
    const formData = {
      nicname: memberInfo.nicname,
      birth: memberInfo.birth,
      phoneNumber: memberInfo.phoneNumber,
      email: memberInfo.email,
      password: memberInfo.password,
      address: address,
    };
    console.log("현재 입력된 값:", formData);
  };

  return (
    <div>
      <MyDiv>
        <h1>Welcome To SIGNUP</h1>
      </MyDiv>
      <LoginWrap>
        <LoginTitle>
          <p className="logo">회원가입</p>
        </LoginTitle>
        <div style={{ marginBottom: "20px" }}>
          <P20 style={{ color: `${PMH.color.RED}` }}>
            만 20세 미만은 회원가입이 불가합니다.
          </P20>
          <P20>아래 정보를 입력하시면 회원가입이 완료됩니다.</P20>
        </div>
        <SignWrap>
          <Form
            initialValues={{
              remember: true,
              name :memberInfo.name,
              nicname: memberInfo.nicname,
              birth: memberInfo.birth,
              phoneNumber: memberInfo.phoneNumber,
              email: memberInfo.email,
              password: memberInfo.password,
              address: memberInfo.address,
            }}
            onFinish={onFinish}
          >
            <div style={{ marginBottom: "80px" }}>
              <P20 style={{ fontWeight: "bold", marginBottom: "20px" }}>
                본인인증정보
              </P20>
              <Form.Item
                name="name"
                rules={[
                  {
                    required: true,
                    message: "이름을 입력하세요.",
                  },
                  {
                    pattern: /^[가-힣]{2,10}$/,
                    message: "한글로 2~10자 사이의 이름을 입력하세요.",
                  },
                  {
                    whitespace: true,
                    message: "이름은 공백만으로 만들 수 없습니다",
                  },
                ]}
              >
                <Input style={areaStyle} placeholder="이름" />
              </Form.Item>
              <Form.Item
                name="nicname"
                rules={[
                  {
                    required: true,
                    message: "닉네임을 입력하세요.",
                  },
                  {
                    pattern: /^[가-힣]{2,10}$/,
                    message: "한글로 2~10자 사이의 이름을 입력하세요.",
                  },
                  {
                    whitespace: true,
                    message: "이름은 공백만으로 만들 수 없습니다",
                  },
                ]}
              >
                <Input style={areaStyle} placeholder="닉네임" />
              </Form.Item>
              <div style={{ display: "flex" }}>
                <Form.Item
                  name="birth"
                  rules={[
                    {
                      required: true,
                      message: "생년월일을 입력하세요.",
                    },
                    {
                      pattern: /^[0-9]+$/,
                      message: "숫자만 입력하세요.",
                    },
                    {
                      whitespace: true,
                      message: "공백만으로 만들 수 없습니다",
                    },
                  ]}
                >
                  <Input
                    style={{ width: 520, height: 60, fontSize: "20px" }}
                    placeholder="생년월일(8자리)"
                  />
                </Form.Item>
                <Form.Item>
                  <Select
                    style={{
                      width: "110px",
                      height: "60px",
                      backgroundColor: `${Common.color.p300}`,
                      marginLeft: "8px",
                      color: `${Common.color.p600}`,
                      fontSize: "20px",
                      borderRadius: "20px",
                    }}
                    placeholder="성별"
                  >
                    <Select.Option value="w">여성</Select.Option>
                    <Select.Option value="m">남성</Select.Option>
                  </Select>
                </Form.Item>
              </div>
              <div style={{ display: "flex" }}>
                <Form.Item name="Number">
                  <Input
                    style={{
                      width: "110px",
                      height: "60px",
                      marginRight: "8px",
                      fontSize: "20px",
                    }}
                    placeholder="010"
                    defaultValue="010"
                    // defaultValue="010"
                  />
                </Form.Item>
                <Form.Item
                  name="phoneNumber"
                  rules={[
                    {
                      required: true,
                      message: "전화번호를 입력 해주세요",
                    },
                    {
                      pattern: /^[0-9]+$/,
                      message: "숫자만 입력하세요.",
                    },
                    {
                      whitespace: true,
                      message: "전화번호는 공백만으로 만들 수 없습니다",
                    },
                  ]}
                >
                  <Input
                    // defaultValue="010"
                    style={{ width: 520, height: 60, fontSize: "20px" }}
                    placeholder="전화번호"
                    // defaultValue="010"
                  />
                </Form.Item>
              </div>
            </div>

            {/* 아래 필수정보 이메일, 비밀번호, 주소 */}
            <div>
              <P20 style={{ fontWeight: "bold", marginBottom: "20px" }}>
                필수정보
              </P20>
              <Form.Item
                name="email"
                rules={[
                  {
                    type: "email",
                    message: "올바른 이메일 형식을 입력하세요.",
                  },
                  {
                    required: true,
                    message: "이메일을 입력하세요.",
                  },
                  {
                    pattern:
                      /^[A-Za-z0-9]([-_.]?[A-Za-z0-9])*@[A-Za-z0-9]([-_.]?[A-Za-z0-9])*\.[A-Za-z]{2,3}$/i,
                    message: "이메일 형식에 맞게 작성해주세요",
                  },
                  {
                    whitespace: true,
                    message: "이메일은 공백만으로 만들 수 없습니다",
                  },
                ]}
              >
                <Input
                  placeholder="이메일(대소문자를 확인해 주세요)"
                  style={areaStyle}
                  onChange={e => {
                    // setUsername(e.target.value);
                    // emailCheck(e.target.value);
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
                  style={areaStyle}
                  type="password"
                  placeholder="비밀번호"
                />
              </Form.Item>
              <Address onAddressChange={updateAddressInfo} />
            </div>
            <Form.Item>
              <Button
                type="primary"
                htmlType="submit"
                style={buttonPrimaryStyle}
              >
                회원가입
              </Button>
            </Form.Item>
          </Form>
        </SignWrap>
      </LoginWrap>
    </div>
  );
};

export default SignupPage;
