import { Checkbox, ConfigProvider, Input, Radio } from "antd";
import React, { useState } from "react";
// import styled from "styled-components";
import {
  AcountNum,
  AgreeCheckBox,
  CheckBank,
  ModalBody,
  ModalHeader,
  ModalWrap,
  TotalAmount,
  UserName,
} from "../../styles/payment/modalpaybankstyle";
const BankTransferModal = () => {
  const onChangeAgree = e => {
    // console.log(`checked = ${e.target.checked}`);
  };
  const [value, setValue] = useState(1);
  const onChangeBank = e => {
    // console.log("radio checked", e.target.value);
    setValue(e.target.value);
  };

  const onChange = e => {
    // console.log(`checked = ${e.target.checked}`);
  };

  return (
    <ModalWrap>
      <ModalBody>
        <div>
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
            <ModalHeader>
              <p>무통장 입금</p>
              {/* <Button icon={<CloseOutlined />} type="text"></Button> */}
            </ModalHeader>
            <div className="modalMain">
              <TotalAmount>
                <p>나나빛</p> <b>58,000원</b>
              </TotalAmount>
              <CheckBank>
                <p>은행</p>
                <Radio.Group
                  colorPrimary="#42b0ff"
                  size={"small"}
                  onChange={onChangeBank}
                  value={value}
                >
                  <Radio value={1}>농협</Radio>
                  <Radio value={2}>국민</Radio>
                  <Radio value={3}>부산</Radio>
                  <Radio value={4}>우리</Radio>
                  <Radio value={5}>신한</Radio>
                  <br />
                  <div />
                  <Radio value={6}>기업</Radio>
                  <Radio value={7}>대구</Radio>
                </Radio.Group>
              </CheckBank>
              <AcountNum>
                <p>입금계좌번호</p>
                <i>주문완료 페이지에서 입금계좌번호를 확인하시기 바랍니다.</i>
                <hr />
              </AcountNum>
              <UserName>
                <p>입금자명</p>
                <Input
                  placeholder="입금자명을 입력해 주세요."
                  maxLength={16}
                  spellCheck={false}
                  style={{
                    borderRadius: "0px",
                    borderTop: "none",
                    borderLeft: "none",
                    borderRight: "none",
                    outline: "none",
                    boxShadow: "none",
                  }}
                />
              </UserName>
              <AgreeCheckBox>
                <Checkbox onChange={onChange}>
                  <p>상기 구매 내역에 동의합니다.</p>
                </Checkbox>
              </AgreeCheckBox>
            </div>
          </ConfigProvider>
        </div>
      </ModalBody>
    </ModalWrap>
  );
};

export default BankTransferModal;
