import { Button, Form, Input } from "antd";
import React, { useEffect, useState } from "react";
import styled from "styled-components";
import { postModify } from "../../api/signupapi/SignupApi";
import { useLocation, useNavigate, useParams } from "react-router";
import ResultModal from "../../components/signup/ResultModal";
import { createSearchParams, useSearchParams } from "react-router-dom";

const ModifyPwWrap = styled.div`
  width: 1220px;
  margin: 0 auto;
  padding-top: 200px;
  padding-bottom: 200px;
  .pwtitle {
    color: #e9b25f;
    text-align: center;
    font-family: "Noto Sans KR";
    font-size: 70px;
    font-style: normal;
    font-weight: 500;
    line-height: normal;
  }
  .pwbg {
    color: #868686;
    text-align: center;
    font-family: "Noto Sans KR";
    font-size: 25px;
    font-style: normal;
    font-weight: 500;
    line-height: normal;
  }
`;

const ModifyPw = () => {
  const navigate = useNavigate();
  const [urlSearchParams, setUrlSearchParams] = useSearchParams();

  const value = urlSearchParams.get("result")
    ? parseInt(urlSearchParams.get("result"))
    : 1;

  // const queryStrDefault = createSearchParams({ result }).toString();
  // const [posts, setPosts] = useState([]);
  // useEffect(() => {}, []);

  const [serverResult, setServerResult] = useState(null);
  const onFinish = values => {
    const result = postModify({ values, successFn, failFn, errorFn });
    // console.log("Success:", values);
    // console.log("Success result:", result);
    // setUrlSearchParams({ result });
    // // navigate(`/modify/${1}`, { state: { result } });
    // navigate(`/modify/1`, { state: { ...result } });
    // navigate(`modify/${id}`, result)
    // moveToModify(result)
  };
  const onFinishFailed = errorInfo => {
    // console.log("Failed:", errorInfo);
  };

  const [resultTitle, setResultTitle] = useState("");
  const [resultContent, setResultContent] = useState("");
  const [reDirect, setReDirect] = useState(0);
  const [modalStyle, setModalStyle] = useState({});
  const [modalStyleBk, setModalStyleBk] = useState({});

  const successFn = result => {
    setModalStyle({});
    setModalStyleBk({});
    setServerResult(result);
    setResultTitle("비밀번호 확인");
    setResultContent("비밀번호 확인에 성공하였습니다.");
    setReDirect(0);
    // console.log(result);
  };
  const failFn = result => {
    setResultTitle("비밀번호 확인 오류");
    setResultContent(
      "비밀번호 확인 오류가 발생하였습니다. 잠시 후 시도해주세요.",
    );
    setReDirect(1);
    // console.log(result);
  };
  const errorFn = result => {
    setModalStyle({ color: "red" });
    setModalStyleBk({ background: "red" });

    setResultTitle("비밀번호 확인");
    setResultContent(result);
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
      navigate(`/modify/1`, { state: { ...serverResult } });
    } else {
      // 팝업닫기
    }
  };

  return (
    <div>
      {resultTitle !== "" ? (
        <ResultModal
          title={resultTitle}
          content={resultContent}
          callFN={closeModal}
          errorbt={modalStyle}
          errorbk={modalStyleBk}
        />
      ) : null}
      <ModifyPwWrap>
        <div className="pwtitle">비밀번호 확인</div>
        <div className="pwbg">
          회원정보 수정을 위해 비밀번호 확인이 필요합니다.
        </div>
        <Form
          style={{
            width: "540px",
            maxWidth: 800,
            height: "252px",
            margin: "0  auto  74px auto",
          }}
          initialValues={{
            remember: true,
            upw: "",
          }}
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
          autoComplete="off"
          layout="vertical"
          requiredMark={false}
        >
          <div style={{ paddingTop: 100 }}>
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
            <Form.Item>
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
                비밀번호 확인
              </Button>
            </Form.Item>
          </div>
        </Form>
      </ModifyPwWrap>
    </div>
  );
};

export default ModifyPw;
