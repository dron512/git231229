import React, { useState } from "react";
import { Form, Input, Button, Modal } from "antd";
import DaumPostcode from "react-daum-postcode";
import { MyInput, postCodeStyle, themeObj } from "../../styles/signup/signup";

const Address = ({ onAddressChange }) => {
  const [zonecode, setZonecode] = useState("");
  const [address, setAddress] = useState("");
  const [isOpen, setIsOpen] = useState(false);
  const [detailedAddress, setDetailedAddress] = useState("");
  const [isModalOpen, setIsModalOpen] = useState(false);

  const completeHandler = data => {
    const { address, zonecode } = data;
    setZonecode(zonecode);
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
      <div>주소*</div>
      <div style={{ display: "flex", width: 193 }} onClick={toggleHandler}>
        <Form.Item valuePropName="zipCode">
          <Input style={{ width: 193, height: 50 }} value={zonecode} />
        </Form.Item>

        <Form.Item>
          <Button
            type="button"
            style={{
              width: "110px",
              height: "50px",
              backgroundColor: "#D68000",
              border: "none",
              marginLeft: "8px",
              color: "white",
            }}
          >
            우편검색
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

      <div style={{ marginTop: "2rem" }}>기본주소</div>
      <Form.Item valuePropName="address">
        <Input style={{ width: 1220, height: 50 }} value={address} />
      </Form.Item>
      <div>상세주소</div>
      <Form.Item name="addressDetail"
      rules={[
        {
          required: true,
          message: "상세주소를 입력하세요.",
        },
        {
          max: 10,
          message: "상세주소는 최대 10자까지 입력 가능합니다.",
        },
      ]}>
        <MyInput value={detailedAddress} onChange={inputChangeHandler} />
      </Form.Item>
    </>
  );
};

export default Address;
