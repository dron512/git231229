import React, { useState } from "react";
import { Form, Input, Button, Modal } from "antd";
import DaumPostcode from "react-daum-postcode";
import styled from "@emotion/styled/macro";
import { Common } from "../../styles/CommonCss";
import { postCodeStyle, themeObj } from "../../styles/sign/signArea";
// import { MyInput, postCodeStyle, themeObj } from "../../styles/signup/signup";

const Address = ({ onAddressChange }) => {
  //   const [zonecode, setZonecode] = useState("");
  const [address, setAddress] = useState("");
  const [isOpen, setIsOpen] = useState(false);
  const [detailedAddress, setDetailedAddress] = useState("");
  const [isModalOpen, setIsModalOpen] = useState(false);

  const completeHandler = data => {
    const { address, zonecode } = data;
    // setZonecode(zonecode);
    setAddress(address);
    onAddressChange({ zonecode, address }); // 부모 컴포넌트에 주소 정보 전달
    setIsOpen(false);
  };

  const closeHandler = state => {
    if (state === "FORCE_CLOSE") {
      setIsOpen(false);
    } else if (state === "COMPLETE_CLOSE") {
      setIsOpen(false);
    }
  };

  const toggleHandler = () => {
    setIsOpen(true);
    setIsModalOpen(true);
  };

  const inputChangeHandler = event => {
    setDetailedAddress(event.target.value);
  };

  const handleOk = () => {
    setIsModalOpen(false);
  };

  const handleCancel = () => {
    setIsModalOpen(false);
  };

  return (
    <>
      <div style={{ display: "flex", width: 193 }} onClick={toggleHandler}>
        <Form.Item valuePropName="zipCode">
          <Input
            style={{ width: 520, height: 60, fontSize: "20px" }}
            // value={zonecode}
            value={address}
            placeholder="주소"
          />
        </Form.Item>

        <Form.Item>
          <Button
            type="button"
            style={{
              width: "110px",
              height: "60px",
              backgroundColor: `${Common.color.p900}`,
              border: "none",
              marginLeft: "8px",
              color: "white",
              fontWeight: "bold",
              fontSize: "16px",
            }}
          >
            주소찾기
          </Button>
        </Form.Item>
      </div>

      {isOpen && (
        <Modal
          title="주소 찾기"
          open={isModalOpen}
          onOk={handleOk}
          onCancel={handleCancel}
          footer=""
        >
          <DaumPostcode
            theme={themeObj}
            style={postCodeStyle}
            onComplete={completeHandler}
            onClose={closeHandler}
          />
        </Modal>
      )}
    </>
  );
};

export default Address;
