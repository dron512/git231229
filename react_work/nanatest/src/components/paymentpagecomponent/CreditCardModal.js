import { Checkbox, ConfigProvider, Input } from "antd";
import React, { useState } from "react";
import {
  AgreeCheckBox,
  CardNum,
  CvcNum,
  ModalBody,
  ModalFooter,
  ModalHeader,
  ModalWrap,
  TotalAmount,
} from "../../styles/payment/modalpaycreditstyle";

const CreditCardModal = () => {
  // CVC 3자리 숫자입력  =========
  const [password, setPassword] = useState("");

  // 숫자만 허용 =========
  const handlePasswordChange = e => {
    const numericValue = e.target.value.replace(/[^0-9]/g, "");
    setPassword(numericValue);
  };

  // 체크박스 ==========
  const onChange = e => {
    // console.log(`checked = ${e.target.checked}`);
  };

  return (
    <ModalWrap className="modalWrap">
      <ModalBody className="modalBody">
        <ConfigProvider
          theme={{
            components: {
              Radio: {
                colorPrimary: "#42b0ff",
              },
              Checkbox: {
                colorPrimary: "#42b0ff",
              },
              Input: {
                colorPrimary: "#42b0ff",
                hoverBorderColor: "#42b0ff",
                activeBorderColor: "#42b0ff",
              },
            },
          }}
        >
          <div className="modalItem">
            <ModalHeader className="modalHeader">
              <p>일반결제</p>
            </ModalHeader>
            <div className="modalMain">
              <TotalAmount className="totalAmount">
                <p>나나빛</p> <b>58,000원</b>
              </TotalAmount>

              <CardNum className="cardNum">
                <p>카드번호</p>
                <Input
                  placeholder="카드번호 [-] 없이 입력"
                  maxLength={16}
                  style={{
                    borderRadius: "0px",
                    borderTop: "none",
                    borderLeft: "none",
                    borderRight: "none",
                    outline: "none",
                    boxShadow: "none",
                  }}
                  spellCheck={false}
                />
              </CardNum>
              <CvcNum className="cvcNum">
                <p>CVC번호</p>
                <Input.Password
                  type="password"
                  placeholder="CVC번호 뒤 3자리"
                  maxLength={3}
                  value={password}
                  onChange={handlePasswordChange}
                  iconRender={() => (
                    <img
                      src={
                        process.env.PUBLIC_URL + "/assets/images/cardimg.svg"
                      }
                      alt="card icon"
                      style={{ width: "25px", height: "22px" }}
                    />
                  )}
                  style={{
                    borderRadius: "0px",
                    borderTop: "none",
                    borderLeft: "none",
                    borderRight: "none",
                    outline: "none",
                    boxShadow: "none",
                  }}
                  spellCheck={false}
                />
              </CvcNum>
              <AgreeCheckBox>
                <Checkbox
                  rules={[{ required: true, message: "color is required!" }]}
                  onChange={onChange}
                >
                  <p>상기 구매 내역에 동의합니다.</p>
                </Checkbox>
              </AgreeCheckBox>
            </div>
            <ModalFooter className="modalFooter"></ModalFooter>
          </div>
        </ConfigProvider>
      </ModalBody>
    </ModalWrap>
  );
};

export default CreditCardModal;
