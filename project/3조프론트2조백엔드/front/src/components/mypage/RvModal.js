import styled from "@emotion/styled/macro";
import React from "react";
import { Common } from "../../styles/CommonCss";
import { Button, Flex, Form, Input, Rate } from "antd";
import { BasicBtR } from "../../styles/basic/basicBt";
import { HeartOutlined } from "@ant-design/icons";
const { TextArea } = Input;

const RvModal = ({ onClose }) => {
  const onChange = e => {
    console.log("Change:", e.target.value);
  };
  const RvModalStyle = styled.div`
    position: fixed;
    display: flex;
    align-items: center;
    justify-content: center;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.7);
    z-index: 999;
  `;
  const ModalWrap = styled.div`
    position: relative;
    min-width: 870px;
    height: 600px;
    background-color: ${Common.color.p100};
    padding: 20px;
    margin: 0 auto;
  `;
  const ModalContent = styled.div`
    position: relative;
    width: 100%;
    /* background-color: aliceblue; */
    .modal-title {
      position: relative;
      display: flex;
      width: 100%;
      /* overflow-y: auto; */
      justify-content: space-between;
      border-bottom: 3px solid ${Common.color.p800};
      padding: 0 0 10px 0;
    }
    .title {
      font-size: 20px;
      font-weight: bold;
    }

    button {
      width: 22px;
      border: none;
      background-color: transparent;
    }
    .table {
      padding: 20px;
      position: relative;
      display: flex;
      gap: 50px;
      font-size: 13px;
      align-items: center;
      border-bottom: 1px solid ${Common.color.p800};
      .hr {
        font-weight: bold;
      }
    }
    .grade {
      padding: 20px;
      position: relative;
      display: flex;
      align-items: center;
      border-bottom: 1px solid ${Common.color.p800};
      gap: 10px;
      p {
        font-size: 20px;
        font-weight: bold;
      }
    }
    .input {
      padding-top: 20px;
      position: relative;
      display: flex;
      /* align-items: center; */
      border-bottom: 1px solid ${Common.color.p800};
    }
    .submit {
      padding-top: 20px;
      position: relative;
      display: flex;
      align-items: center;
      /* border-bottom: 1px solid ${Common.color.p800}; */
      /* background: ${Common.color.b900}; */
      justify-content: center;
      button {
        width: 120px;
        height: 40px;
        background: ${Common.color.b900};
        color: ${Common.color.p100};
        font-size: 13px;
        cursor: pointer;
      }
    }
  `;

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
              src={process.env.PUBLIC_URL + "/images/moon.jpg"} // 수정된 부분
              style={{ width: "62px", height: "62px" }}
              //   alt="bag"
            />
            <ul className="hr">
              <li>제품명</li>
              <li>매장명</li>
              <li>주문방식</li>
            </ul>
            <ul className="br">
              <li>나는술파는 고라니</li>
              <li>고라니 술집</li>
              <li>픽업</li>
            </ul>
          </div>
          <div className="grade">
            <p>상품은 어떠셨나요?</p>

            <Rate
              style={{
                //   width: "200px",
                fontSize: "40px",
              }}
            />
            <HeartOutlined />
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
                // onChange={e => handleContentsChange("contents", e.target.value)}
              />
            </Form.Item>
          </div>
          <div className="submit">
            <BasicBtR onClick={onClose}>등록하기</BasicBtR>
          </div>
        </ModalContent>
      </ModalWrap>
    </RvModalStyle>
  );
};

export default RvModal;
