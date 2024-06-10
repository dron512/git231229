import { LockOutlined, UserOutlined } from "@ant-design/icons";
import { Button, Checkbox, Form, Input } from "antd";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Common } from "../../styles/CommonCss";
import { LoginBt, LoginTitle, LoginWrap } from "../../styles/login/loginCss";
import axios from "axios";
import { SERVER_URL } from "../../api/config";
import Swal from "sweetalert2";

const SignFindIdPwPage = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [birthdate, setBirth] = useState("");

  const findEmail = () => {
    if(!birthdate.target){
      Swal.fire({
        title:"<p style='font-size:4rem;margin:1rem;'>생년월일을 입력하세요</p>",
        icon: "info",
        width: 600,
        confirmButtonText: `<span style="display:bolck;font-size:4rem;width:200px;padding:1rem;">확인</span>`,
        confirmButtonColor: `${Common.color.f900}`,
      })
      
    }else if(!phone.target){
      Swal.fire({
        title:"<p style='font-size:4rem;margin:1rem;'>폰번호를 입력하세요</p>",
        icon: "info",
        width: 600,
        confirmButtonText: `<span style="display:bolck;font-size:4rem;width:200px;padding:1rem;">확인</span>`,
        confirmButtonColor: `${Common.color.f900}`,
      })
    }else{
      axios.post(`${SERVER_URL}/login/findEmail`, {
        birthdate: birthdate.target.value,
        phone: phone.target.value,
      }).then((response) => {
        console.log(response.data);
        Swal.fire({
          title:
          `<p style='font-size:4rem;margin:1rem;'>EMAIL\n\n ${response.data}\n\n</p>`,
          icon: "info",
          width: 600,
          confirmButtonText: `<span style="display:bolck;font-size:4rem;width:200px;padding:1rem;">확인</span>`,
          confirmButtonColor: `${Common.color.f900}`,
        })
      }).catch((error) => {
        console.log(error.response);
        Swal.fire({
          title:
          `<p style='font-size:4rem;margin:1rem;'>EMAIL\n\n ${error.response.data}\n\n</p>`,
          icon: "info",
          width: 600,
          confirmButtonText: `<span style="display:bolck;font-size:4rem;width:200px;padding:1rem;">확인</span>`,
          confirmButtonColor: `${Common.color.f900}`,
        })
      });
    }
  };

  return (
    <div>
      <LoginWrap>
        <LoginTitle>
          <p className="logo">ALCHOHOL HOLIC</p>
          <div className="email-line">
            <div className="line"></div>
            <p>이메일 찾기</p>
            <div className="line"></div>
          </div>
        </LoginTitle>
        <Form
          name="normal_login"
          className="login-form"
        >
          <Form.Item
            name="birthdate"
            rules={[
              {
                required: true,
                message: "생년월일을 입력해 주세요!",
              },
            ]}
          >
            <Input
              prefix={<UserOutlined className="site-form-item-icon" />}
              placeholder="생년월일"
              name="birthdate"
              onChange={setBirth}
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
              onChange={setPhone}
            />
          </Form.Item>

          <Form.Item>
            <Button
              type="primary"
              htmlType="submit"
              style={{
                width: "100%",
                height: "60px",
                background: `${Common.color.f900}`,
                fontSize: "20px",
              }}
              onClick={findEmail}
            >
              이메일 찾기
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
            onChange={setEmail}
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
            onChange={setPhone}
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
