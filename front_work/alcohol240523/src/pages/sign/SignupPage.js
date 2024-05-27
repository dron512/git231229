import { Button, Form, Input, Select } from "antd";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { useRecoilState } from "recoil";
import { postSign } from "../../api/signUpApi";
import { addressState } from "../../atom/addressState";
import Address from "../../components/singup/Address";
import { P20, SignWrap } from "../../styles/basic";
import { Common } from "../../styles/CommonCss";
import { LoginTitle, LoginWrap } from "../../styles/login/loginCss";
import { areaStyle, buttonPrimaryStyle } from "../../styles/sign/signArea";

// const initState = {
//   email: "aaa@naver.com",
//   nickname: "아무거나",
//   password: "aA123456!",
//   passwordch: "",
//   address: "",
//   address2: "",
//   gender: "MALE",
//   birthdate: "20010510",
//   phone: "01012345678",
// };

const initState = {
  email: "",
  nickname: "",
  password: "",
  passwordch: "",
  address: "",
  address2: "",
  gender: "",
  birthdate: "",
  phone: "",
};
const SignupPage = () => {
  const navigate = useNavigate();
  const [memberInfo, setMemberInfo] = useState(initState);

  // const [address, setAddress] = useState("");
  const [nickname, setNickname] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordch, setPasswordch] = useState("");
  const [gender, setGender] = useState("");
  const [birthdate, setBirthdate] = useState("");
  const [phone, setPhone] = useState("");
  const [address, setAddress] = useRecoilState(addressState);
  const [values, setValues] = useState({});
  const [address2, setAddress2] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [errorCode, setErrorCode] = useState("");

  const updateAddressInfo = ({ zonecode, address }) => {
    // 주소 정보 업데이트
    // setZonecode(zonecode);
    setAddress(address);
  };

  const handleGenderChange = value => {
    setGender(value); // 성별 상태 업데이트
    setValues(prevValues => ({
      ...prevValues,
      gender: value,
    }));
  };
  const onFinish = inivalues => {
    const values = {
      email,
      password,
      passwordch,
      birthdate,
      nickname,
      phone,
      gender: inivalues.gender,
      address,
      address2,
    };
    console.log("보냄" + JSON.stringify(values));
    postSign({
      values,
      address,
      withdrawStatus: "Y",
      successFn,
      failFn,
      errorFn,
    });
  };

  const successFn = data => {
    // console.log("successFn : ", data);
    setMemberInfo(data);
    navigate(`/sign/in`);
  };

  const failFn = data => {
    console.log("failFn : ", data);
    setErrorMessage(data.errorMessage);
    setErrorCode(data.errorCode);
    alert(data.errorMessage);
  };

  const errorFn = data => {
    // console.log("errorFn : ", data);
    alert("서버상태 불안정 다음에 회원가입 시도");
    setMemberInfo(data);
  };

  useEffect(() => {
    // address 상태가 변경될 때마다 initialValues 업데이트
    setMemberInfo(prevState => ({
      ...prevState,
      address: address,
    }));
  }, [address]);

  return (
    <div>
      <LoginWrap>
        <LoginTitle>
          <p className="logo">회원가입</p>
        </LoginTitle>
        <div style={{ marginBottom: "20px" }}>
          <P20 style={{ color: `${Common.color.f900}` }}>
            만 20세 미만은 회원가입이 불가합니다.
          </P20>
          <P20>아래 정보를 입력하시면 회원가입이 완료됩니다.</P20>
        </div>

        <SignWrap>
          <Form
            name="normal_login"
            className="login-form"
            initialValues={{
              remember: true,
              email: memberInfo.email,
              password: memberInfo.password,
              passwordch: memberInfo.passwordch,
              birthdate: memberInfo.birthdate,
              nickname: memberInfo.nickname,
              phone: memberInfo.phone,
              gender: memberInfo.gender,
              address: address,
              address2: memberInfo.address2,
            }}
            onFinish={onFinish}
          >
            <div style={{ marginBottom: "80px" }}>
              <P20 style={{ fontWeight: "bold", marginBottom: "20px" }}>
                본인인증정보
              </P20>
              <Form.Item
                name="nickname"
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
                <Input
                  style={areaStyle}
                  placeholder="닉네임"
                  onChange={e => setNickname(e.target.value)}
                />
              </Form.Item>
              <div style={{ display: "flex" }}>
                <Form.Item
                  name="birthdate"
                  rules={[
                    {
                      required: true,
                      message: "생년월일을 입력하세요.",
                    },
                    {
                      pattern: /^[0-9]{8}$/,
                      message: "숫자로 8자로 입력해주세요.",
                    },
                    {
                      pattern: /^[0-9]+$/,
                      message: "숫자만 입력하세요.",
                    },
                    {
                      whitespace: true,
                      message: "공백만으로 만들 수 없습니다",
                    },
                    {
                      validator: (_, value) => {
                        // 주민등록번호 문자열을 날짜로 변환
                        const year = value.substr(0, 4);
                        const month = value.substr(4, 2);
                        const day = value.substr(6, 2);

                        // 현재 날짜 구하기
                        const currentDate = new Date();

                        // 생년월일 계산
                        const birthYear =(
                          parseInt(year.substr(0, 2)) > 19
                            ? 2000 + parseInt(year.substr(2, 2))
                            : 1900 + parseInt(year.substr(2, 2)));
                        const birthDate = new Date(
                          birthYear,
                          parseInt(month),
                          parseInt(day),
                        );

                        // 나이 계산
                        const age =
                          currentDate.getFullYear() - birthDate.getFullYear();

                        // 생일이 지났는지 체크
                        // if (
                        //   currentDate.getMonth() < birthDate.getMonth() ||
                        //   (currentDate.getMonth() === birthDate.getMonth() &&
                        //     currentDate.getDate() < birthDate.getDate())
                        // )
                          if (age < 20) {
                            // 20세 미만인 경우 에러 반환
                            return Promise.reject(
                              "20세 미만은 가입할 수 없습니다.",
                            );
                          }
                        return Promise.resolve();
                      },
                    },
                  ]}
                >
                  <Input
                    style={{ width: 520, height: 60, fontSize: "20px" }}
                    placeholder="생년월일(8자리)"
                    onChange={e => setBirthdate(e.target.value)}
                  />
                </Form.Item>
                <Form.Item name="gender">
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
                    onClick={handleGenderChange}
                  >
                    <Select.Option value="FEMALE">여성</Select.Option>
                    <Select.Option value="MALE">남성</Select.Option>
                  </Select>
                </Form.Item>
              </div>
              <div style={{ display: "flex" }}>
                <Form.Item
                  name="phone"
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
                    onChange={e => setPhone(e.target.value)}
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
                  // {
                  //   pattern:
                  //     /^[A-Za-z0-9]([-_.]?[A-Za-z0-9])*@[A-Za-z0-9]([-_.]?[A-Za-z0-9])*\.[A-Za-z]{2,3}$/i,
                  //   message: "이메일 형식에 맞게 작성해주세요",
                  // },
                  {
                    whitespace: true,
                    message: "이메일은 공백만으로 만들 수 없습니다",
                  },
                ]}
              >
                <Input
                  placeholder="이메일(대소문자를 확인해 주세요)"
                  style={areaStyle}
                  onChange={e => setEmail(e.target.value)}
                />
                {/* {errorMessage.includes("이메일") && (
                  <span style={{ color: "red" }}>{errorMessage}</span>
                )} */}
              </Form.Item>
              <Form.Item
                name="password"
                rules={[
                  {
                    required: true,
                    message: "비밀번호를 입력해 주세요!",
                  },
                  {
                    pattern:
                      /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$/,
                    message:
                      "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용해야 합니다.",
                  },
                ]}
              >
                <Input.Password
                  style={areaStyle}
                  type="password"
                  placeholder="비밀번호"
                  onChange={e => setPassword(e.target.value)}
                />
              </Form.Item>
              <Form.Item
                name="passwordch"
                dependencies={["password"]}
                hasFeedback
                rules={[
                  {
                    required: true,
                    message: "비밀번호 확인을 입력해 주세요!",
                  },
                  ({ getFieldValue }) => ({
                    validator(_, value) {
                      if (!value || getFieldValue("password") === value) {
                        return Promise.resolve();
                      }
                      return Promise.reject(
                        new Error("비밀번호가 일치하지 않습니다."),
                      );
                    },
                  }),
                ]}
              >
                <Input.Password
                  style={areaStyle}
                  placeholder="비밀번호 확인"
                  onChange={e => setPasswordch(e.target.value)}
                />
              </Form.Item>

              <Address onAddressChange={updateAddressInfo} />
              <Form.Item
                name="address2"
                rules={[
                  {
                    required: true,
                    message: "상세주소를 입력하세요.",
                  },
                  {
                    max: 10,
                    message: "상세주소는 최대 10자까지 입력 가능합니다.",
                  },
                ]}
              >
                <Input
                  style={{ height: 60, fontSize: "20px" }}
                  onChange={e => setAddress2(e.target.value)}
                  placeholder="상세주소"
                />
              </Form.Item>
            </div>
            <Form.Item>
              <Button
                type="primary"
                htmlType="submit"
                style={buttonPrimaryStyle}
                // onClick={handleClickSearch}
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
