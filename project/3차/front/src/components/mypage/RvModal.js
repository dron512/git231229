import styled from "@emotion/styled/macro";
import React, { useState } from "react";
import { Common } from "../../styles/CommonCss";
import { Button, Flex, Form, Input, Rate } from "antd";
import { BasicBtR } from "../../styles/basic/basicBt";
import { HeartOutlined } from "@ant-design/icons";
import {
  ModalContent,
  ModalDeletWrap,
  ModalWrap,
  RvModalStyle,
  SubmitBt,
} from "../../styles/common/revModalCss";
import {
  deleteReview,
  getReviewcheck,
  postReviewcreate,
} from "../../api/reviewApi";
const { TextArea } = Input;

const initState = {
  alcohol: 0,
  writing: "",
  grade: 0,
  picture: "",
};

const RvModal = ({ onClose, code }) => {
  const [postData, setPostData] = useState(initState);
  const [writingData, setWritingData] = useState("");
  const [gradeData, setGradeData] = useState();

  const handleGradeChange = value => {
    setGradeData(value);
    console.log("평점:", value);
  };

  const handleWritingChange = e => {
    setWritingData(e.target.value);
    console.log("리뷰작성:", e.target.value);
  };

  const fetchData = () => {
    postReviewcreate({
      reivewParam: {
        code: code.alcoholcode,
        writing: writingData,
        grade: gradeData,
        picture: "",
      },
      successFn,
      failFn,
      errorFn,
    });
  };

  const successFn = data => {
    setPostData(data);
    onClose();
    getReviewcheck(data);
  };
  const failFn = data => {
    setPostData(false);
    alert("failFn : 데이터 호출에 실패하였습니다.");
  };

  const errorFn = data => {
    alert("서버상태 불안정 그래서, 데모테스트했음.");
  };
  return (
    <RvModalStyle>
      <ModalWrap>
        <ModalContent>
          <div className="modal-title">
            <p className="title">리뷰작성</p>
            <button onClick={onClose}>
              <img src={process.env.PUBLIC_URL + "/images/close2.svg"}></img>
            </button>
          </div>
          <div className="table">
            <img
              src={process.env.PUBLIC_URL + code.picture}
              style={{ width: "62px", height: "62px" }}
              //   alt="bag"
            />
            <ul className="hr">
              <li>제품명</li>
              <li>매장명</li>
              <li>주문방식</li>
            </ul>
            <ul className="br">
              <li>{code.name}</li>
              <li>{code.marketname}</li>
              <li> {code.delivery}</li>
            </ul>
          </div>
          <div className="grade">
            <p>상품은 어떠셨나요?</p>

            <Rate
              style={{
                fontSize: "40px",
              }}
              value={gradeData}
              onChange={handleGradeChange}
            />
          </div>

          <div className="input">
            <Form.Item style={{ width: "100%" }} name="contents">
              <TextArea
                // value={formData.contents}
                style={{
                  fontSize: "16px",
                  boxShadow: "none",
                }}
                rows={4}
                showCount={true}
                maxLength={250}
                placeholder="내용을 입력해 주세요"
                autoSize={{
                  minRows: 9,
                  maxRows: 4,
                }}
                spellCheck={false}
                value={writingData}
                onChange={handleWritingChange}
                // onChange={e => handleContentsChange("contents", e.target.value)}
              />
            </Form.Item>
          </div>
          <div className="submit">
            <BasicBtR onClick={fetchData}>등록하기</BasicBtR>
          </div>
        </ModalContent>
      </ModalWrap>
    </RvModalStyle>
  );
};

export default RvModal;

export const RvDelete = ({ onClose, code, refreshData }) => {
  console.log("code", code);
  const picCodePk = (code.picture.match(/\d+/g) || [])
    .map(number => parseInt(number.replace(/^0+/, ""), 10)) // 첫 번째 자리 숫자가 0이면 제거
    .join("");

  const fetchData = picCodePk => {
    deleteReview({
      code: picCodePk,
      successFn: () => {
        onClose();
        refreshData();
      },
      failFn,
      errorFn: data => {
        alert("서버상태 불안정 다음에 상품불러오기 시도");
      },
    });
  };

  const successFn = data => {
    onClose();
  };
  const failFn = data => {
    alert("failFn : 데이터 호출에 실패하였습니다.");
  };

  return (
    <>
      <RvModalStyle>
        <ModalDeletWrap>
          <ModalContent>
            <div className="modal-title">
              <p className="title">리뷰삭제</p>

              <button onClick={onClose}>
                <img src={process.env.PUBLIC_URL + "/images/close2.svg"}></img>
              </button>
            </div>
            <div className="table">
              <img
                src={process.env.PUBLIC_URL + code.picture}
                style={{ width: "62px", height: "62px" }}
                //   alt="bag"
              />
              <ul className="hr">
                <li>제품명</li>
                <li>내용</li>
              </ul>
              <ul className="br">
                <li>{code.name}</li>
                <li> {code.writing}</li>
              </ul>
            </div>
            <div className="grade">
              <p>리뷰를 삭제하시겠습니까?</p>
            </div>

            <SubmitBt>
              <BasicBtR
                style={{ background: Common.color.f900 }}
                onClick={() => fetchData(code.id)}
              >
                네
              </BasicBtR>
              <BasicBtR onClick={onClose}>아니요</BasicBtR>
            </SubmitBt>
          </ModalContent>
        </ModalDeletWrap>
      </RvModalStyle>
    </>
  );
};
