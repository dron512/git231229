import { Button, Form, Input } from "antd";
import {
  buttonStyle,
  flexContainer,
  formStyle,
  inputBt,
} from "../../styles/signup/signup";

const handleCheckDuplicate = async values => {
  try {
    const response = await fetch(`/api/checkDuplicate/${values.userid}`);
    const data = await response.json();

    if (data.isDuplicate) {
      // console.log("아이디가 중복됩니다. 다른 아이디를 입력해주세요.");
    } else {
      // console.log("아이디가 사용 가능합니다.");
    }
  } catch (error) {
    // console.error("중복확인 요청에 실패했습니다:", error.message);
  }
};
export default function SignupContent() {
  <>
    <div style={formStyle}>이름*</div>
    <Form.Item
      name="name"
      rules={[
        {
          type: "text",
        },
      ]}
    >
      <Input style={inputBt} />
    </Form.Item>

    <div style={formStyle}>아이디*</div>
    <div style={flexContainer}>
      <Form.Item
        name="userid"
        rules={[
          {
            required: true,
            message: "아이디를 입력하세요!",
          },
        ]}
      >
        <Input style={{ width: "973px", height: "50px" }} />
      </Form.Item>
      <Form.Item>
        <Button
          type="button"
          onClick={values => handleCheckDuplicate(values)}
          style={buttonStyle}
        >
          중복확인
        </Button>
      </Form.Item>
    </div>

    <div>비밀번호*</div>
    <Form.Item name="password">
      <Input.Password style={inputBt} />
    </Form.Item>
    <div>비밀번호 확인*</div>
    <Form.Item
      name="confirm"
      dependencies={["password"]}
      hasFeedback
      rules={[
        ({ getFieldValue }) => ({
          validator(_, value) {
            if (!value || getFieldValue("password") === value) {
              return Promise.resolve();
            }
            return Promise.reject(new Error("비밀번호 다시 확인해주세요!"));
          },
        }),
      ]}
    >
      <Input.Password style={inputBt} />
    </Form.Item>
  </>;
}
