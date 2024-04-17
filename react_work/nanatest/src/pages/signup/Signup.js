import { Button, Checkbox, Form, Input, Modal } from "antd";
import React, { useEffect, useState } from "react";
import {
  getList,
  getPayItemList,
  postSign,
  postSignCheck,
} from "../../api/signupapi/SignupApi";
import Address from "../../components/signup/Address";
import ChildComponent from "../../components/signup/ChildComponent ";
import {
  MyInput,
  SignupWrap,
  addbt,
  babyInfo,
  babyInfoPush,
  buttonPrimaryBack,
  buttonPrimaryStyle,
  buttonStyle,
  emailtitle,
  flexContainer,
  formStyle,
  inputBt,
} from "../../styles/signup/signup";
import { useNavigate } from "react-router";
import ResultModal from "../../components/signup/ResultModal";
const initState = {
  nm: "",
  uid: "",
  upw: "",
  confirm: "",
  zipCode: "",
  address: "",
  addressDetail: "",
  phoneNumber: "",
  email: "",
  children: [{ ichildAge: "", gender: "" }],
};

const Signup = () => {
  const navigate = useNavigate();
  const [memberInfo, setMemberInfo] = useState(initState);
  const [zonecode, setZonecode] = useState("");
  const [address, setAddress] = useState("");
  const [agreeBt, setAgreeBt] = useState([]);
  const [idCheck, setIdCheck] = useState("");
  const [resultTitle, setResultTitle] = useState("");
  const [resultContent, setResultContent] = useState("");
  const [reDirect, setReDirect] = useState(0);

  const updateAddressInfo = ({ zonecode, address }) => {
    // 주소 정보 업데이트
    setZonecode(zonecode);
    setAddress(address);
  };

  const tailFormItemLayout = {
    wrapperCol: {
      xs: {
        span: 24,
        offset: 0,
      },
      sm: {
        span: 16,
        offset: 8,
      },
    },
  };

  const successFn = result => {
    setModalStyle({});
    setModalStyleBk({});
    setMemberInfo(result);
    setResultTitle("회원 가입");
    setResultContent("회원 가입이 되었습니다. 로그인 해주세요.");
    setReDirect(0);
    // userPk(result)
  };

  const failFn = () => {
    setResultTitle("항목 확인");
    setResultContent(
      <div>
        잘못된 양식의 항목있습니다.
        <br /> 다시 확인해주세요.
      </div>,
    );
    setReDirect(1);
  };
  const errFn = () => {
    setModalStyle({ color: "red" });
    setModalStyleBk({ background: "red" });
    setResultTitle("서버 오류");
    setResultContent(
      <div>
        오류가 발생하였습니다. <br />
        관리자에게 문의해 주세요.
      </div>,
    );
    setReDirect(1);
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const result = await getList();
        setAgreeBt(result);
        setRequiredList(Array(result.length).fill(false));
      } catch (error) {
        alert("데이터 호출에 실패하였습니다.");
      }
    };

    fetchData();
  }, []);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const result = await getPayItemList();
        // console.log(result);
      } catch (error) {
        alert("데이터 호출에 실패하였습니다.");
      }
    };

    fetchData();
  }, []);

  const [required, setRequired] = useState(false);
  const [modalStyle, setModalStyle] = useState({});
  const [modalStyleBk, setModalStyleBk] = useState({});
  const [isCheckedaa, setIsCheckedaa] = useState(false);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [requiredList, setRequiredList] = useState(
    Array(agreeBt.length).fill(false),
  );

  const updateRequiredList = (index, isChecked) => {
    const newRequiredList = [...requiredList];
    newRequiredList[index] = isChecked;
    setRequiredList(newRequiredList);
  };
  const showModal = () => {
    setIsModalOpen(true);
  };
  const handleModalOk = () => {
    // console.log(requiredList);

    // 모든 동의 항목이 체크되었을 때만 setIsCheckedaa(true) 호출
    if (requiredList.every(item => item)) {
      setIsCheckedaa(true);
    } else {
      setIsCheckedaa(false);
    }

    setIsModalOpen(false);
  };

  const handleModalCancel = () => {
    setIsModalOpen(false);
  };
  const [userId, setUserId] = useState("");

  const handleClickCheck = () => {
    const userObject = {
      uid: userId,
    };

    postSignCheck({ userObject, successFnid, failFnid, errorFnid });
  };

  const [asdf, setAsdf] = useState(0);
  const [modalShow, setModealShow] = useState(false);
  const [modalMessage, setModalMessage] = useState("");
  const [titleResult, setTitleResult] = useState("");

  const successFnid = result => {
    setModalStyle({});
    setModalStyleBk({});
    setResultTitle("아이디 중복 확인");
    setResultContent("사용할 수 있는 아이디입니다.");
    setReDirect(0);
    setAsdf(result);
  };

  const failFnid = result => {
    setResultTitle("아이디 중복 확인");
    setResultContent(result);
    setReDirect(1);
    // console.log(result);
  };

  const errorFnid = result => {
    setModalStyle({ color: "red" });
    setModalStyleBk({ background: "red" });
    setResultTitle("서버 오류");
    setResultContent(result);
    setReDirect(1);
    // console.log(result);
  };

  const closeModal = () => {
    setResultTitle("");
    setResultContent("");
  };

  const onFinish = values => {
    // 회원가입 버튼 클릭 시 체크박스가 체크되어 있는지 확인
    if (!isCheckedaa) {
      // 체크박스가 체크되지 않은 경우 회원가입 처리를 하지 않고 반환
      setTitleResult("약관 동의");
      setModalMessage("약관에 동의해주세요.");
      setModealShow(true);
      return;
    }
    +(
      // 회원가입 처리 코드
      setMemberInfo({ ...values })
    );
    values.address = address;
    values.zipCode = zonecode;
    // console.log("Success:", values);
    if (asdf === 1) {
      postSign({ values, successFn, failFn, errFn });
      navigate("/login");
    } else {
      setTitleResult("아이디 중복");
      setModalMessage("아이디 중복확인해주세요.");
      setModealShow(true);
    }
  };

  const modalClose = () => {
    setModealShow(false);
  };

  const onFinishFailed = errorInfo => {
    // console.log("Failed:", errorInfo);
  };
  const handleClickBack = () => {
    navigate(-1);
  };

  const [username, setUsername] = React.useState("");
  const [password, setPassword] = React.useState("");
  const [passwordChk, setPasswordChk] = React.useState("");

  const emailRegEx =
    /^[A-Za-z0-9]([-_.]?[A-Za-z0-9])*@[A-Za-z0-9]([-_.]?[A-Za-z0-9])*\.[A-Za-z]{2,3}$/i;
  const passwordRegEx = /^[A-Za-z0-9]{8,20}$/;

  const emailCheck = username => {
    return emailRegEx.test(username); //형식에 맞을 경우, true 리턴
  };
  const passwordCheck = password => {
    if (password.match(passwordRegEx) === null) {
      //형식에 맞지 않을 경우 아래 콘솔 출력
      // console.log("비밀번호 형식을 확인해주세요");
      return;
    } else {
      // 맞을 경우 출력
      // console.log("비밀번호 형식이 맞아요");
    }
  };
  const passwordDoubleCheck = (password, passwordChk) => {
    if (password !== passwordChk) {
      // console.log("비밀번호가 다릅니다.");
      return;
    } else {
      // console.log("비밀번호가 동일합니다");
    }
  };

  return (
    <div>
      {modalShow && (
        <ResultModal
          title={titleResult}
          message={modalMessage}
          callFN={modalClose}
        />
      )}

      {resultTitle !== "" ? (
        <ResultModal
          title={resultTitle}
          content={resultContent}
          callFN={closeModal}
          errorbt={modalStyle}
          errorbk={modalStyleBk}
        />
      ) : null}
      <SignupWrap>
        <div className="signimg">
          <img src={process.env.PUBLIC_URL + "/assets/images/signup.svg"} />
        </div>
        <span>
          회원가입시 첫 구매 10% 할인쿠폰이 지급됩니다! (30,000원 이상 구매시)
        </span>
        <div className="signinfo">회원정보입력</div>
        <Form
          name="basic"
          labelCol={{
            span: 8,
          }}
          wrapperCol={{
            span: 16,
          }}
          initialValues={{
            remember: true,
            nm: memberInfo.nm,
            uid: memberInfo.uid,
            upw: memberInfo.upw,
            confirm: memberInfo.confirm,
            zipCode: memberInfo.zipCode,
            address: memberInfo.address,
            addressDetail: memberInfo.addressDetail,
            phoneNumber: memberInfo.phoneNumber,
            email: memberInfo.email,
            children: [{ ichildAge: "", gender: "" }],
          }}
          autoComplete="off"
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
        >
          <div style={formStyle}>이름*</div>
          <Form.Item
            name="nm"
            rules={[
              {
                required: true,
                message: "이름을 입력하세요.",
              },
              {
                pattern: /^[가-힣]{2,4}$/,
                message: "한글로 2~4자 사이의 이름을 입력하세요.",
              },
              {
                whitespace: true,
                message: "이름은 공백만으로 만들 수 없습니다",
              },
            ]}
          >
            <Input style={inputBt} />
          </Form.Item>

          <div style={formStyle}>아이디*</div>
          <div style={flexContainer}>
            <Form.Item
              name="uid"
              rules={[
                {
                  required: true,
                  message: "아이디를 입력하세요!",
                },
                {
                  whitespace: true,
                  message: "아이디는 공백만으로 만들 수 없습니다",
                },
              ]}
            >
              <Input
                style={{ width: "973px", height: "50px" }}
                onChange={e => setUserId(e.target.value)}
              />
            </Form.Item>
            <Form.Item>
              <Button
                type="button"
                style={buttonStyle}
                onClick={handleClickCheck}
              >
                중복확인
              </Button>
            </Form.Item>
          </div>

          <div>비밀번호*</div>
          <Form.Item
            name="upw"
            rules={[
              {
                required: true,
                message: "비밀번호를 입력하세요.",
              },
              {
                min: 8,
                message:
                  "비밀번호는 공백을 제외한 영어와 숫자, 특수문자를 하나 이상 포함한 8~16자리이어야 합니다.",
              },
              {
                max: 16,
                message:
                  "비밀번호는 공백을 제외한 영어와 숫자, 특수문자를 하나 이상 포함한 8~16자리이어야 합니다.",
              },
              // {
              //   pattern: /^[A-Za-z0-9]{8,16}$/,
              //   message: "비밀번호 양식에 맞게 작성해주세요.",
              // },
              {
                whitespace: true,
                message: "비밀번호는 공백만으로 만들 수 없습니다",
              },
            ]}
          >
            <Input.Password
              style={inputBt}
              onChange={e => {
                setPassword(e.target.value);
                passwordCheck(e.target.value);
              }}
            />
          </Form.Item>
          <div>비밀번호 확인*</div>
          <Form.Item
            name="confirm"
            dependencies={["upw"]}
            hasFeedback
            rules={[
              ({ getFieldValue }) => ({
                validator(_, value) {
                  if (!value || getFieldValue("upw") === value) {
                    return Promise.resolve();
                  }
                  return Promise.reject(
                    new Error("비밀번호 다시 확인해주세요!"),
                  );
                },
              }),
            ]}
          >
            <Input.Password
              style={inputBt}
              onChange={e => {
                setPasswordChk(e.target.value);
                passwordDoubleCheck(password, e.target.value);
              }}
            />
          </Form.Item>

          <Address onAddressChange={updateAddressInfo} />
          <div>휴대전화*</div>
          <Form.Item
            name="phoneNumber"
            rules={[
              {
                required: true,
                message: "전화번호를 입력 해주세요",
              },
              {
                whitespace: true,
                message: "전화번호는 공백만으로 만들 수 없습니다",
              },
            ]}
          >
            <Input style={emailtitle} />
          </Form.Item>
          <div>이메일*</div>
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
            <MyInput
              onChange={e => {
                setUsername(e.target.value);
                emailCheck(e.target.value);
              }}
            />
          </Form.Item>

          <Form.List name="children">
            {(fields, { add, remove }) => (
              <>
                <div style={babyInfo}>
                  <div style={babyInfoPush}>우리아이 정보입력</div>
                  <Form.Item>
                    <Button
                      type="primary"
                      style={addbt}
                      onClick={() => fields.length < 3 && add()}
                    >
                      추가하기
                    </Button>
                  </Form.Item>
                </div>

                {fields.map(({ key, name }) => (
                  <ChildComponent
                    key={key}
                    name={name}
                    onSelet={() => remove(name)}
                  />
                ))}
              </>
            )}
          </Form.List>
          <div className="agreesign">
            <Form.Item
              value="checked"
              rules={[
                {
                  validator: (_, value) =>
                    value
                      ? Promise.resolve()
                      : Promise.reject(new Error("약관 동의를 체크해주세요.")),
                },
              ]}
              {...tailFormItemLayout}
            >
              <Checkbox
                style={{ marginTop: "20px", marginRight: "400px" }}
                onClick={showModal}
                checked={isCheckedaa}
              >
                동의하시겠습니까?
              </Checkbox>
              <Modal
                okText="확인"
                cancelText="취소"
                open={isModalOpen}
                onOk={handleModalOk}
                onCancel={handleModalCancel}
              >
                {agreeBt.map((item, iclause) => (
                  <li key={iclause}>
                    <h3>{item.title}</h3>
                    <div
                      style={{
                        overflow: "scroll",
                        height: 350,
                        overflowX: "hidden",
                      }}
                    >
                      <p>{item.contents}</p>
                    </div>
                    <Checkbox
                      key={agreeBt.includes}
                      type="checkbox"
                      name="bothcheck"
                      onChange={e =>
                        updateRequiredList(iclause, e.target.checked)
                      }
                    >
                      동의함
                    </Checkbox>
                  </li>
                ))}
              </Modal>
            </Form.Item>
          </div>
          <div className="signupbt">
            <Form.Item>
              <Button
                type="primary"
                style={buttonPrimaryBack}
                onClick={handleClickBack}
              >
                <span style={{ color: "#868686" }}>뒤로가기</span>
              </Button>
            </Form.Item>
            <Form.Item>
              <Button
                type="primary"
                htmlType="submit"
                style={buttonPrimaryStyle}
              >
                회원가입
              </Button>
            </Form.Item>
          </div>
        </Form>
      </SignupWrap>
    </div>
  );
};

export default Signup;
