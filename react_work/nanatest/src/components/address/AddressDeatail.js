import { Button, Form, Input, Modal } from "antd";
import React, { useState } from "react";
import DaumPostcode from "react-daum-postcode";
import {
  MyInputDetail,
  postCodeStyle,
  themeObj,
} from "../../styles/signup/signup";

const AddressDetail = ({ onAddressChange, item }) => {
  const [zonecode, setZonecode] = useState("");
  const [address, setAddress] = useState("");
  const [addressDetail, setAddressDetail] = useState("");
  const [isOpen, setIsOpen] = useState(false);
  const [isModalOpen, setIsModalOpen] = useState(false);

  const completeHandler = data => {
    const { address, zonecode, addressDetail } = data;
    setZonecode(zonecode);
    setAddress(address);
    setAddressDetail(addressDetail);
    onAddressChange({ zonecode, address, addressDetail }); // 부모 컴포넌트에 주소 정보 전달
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
    setAddressDetail(event.target.value);
    
  };

  const handleOk = () => {
    setIsModalOpen(false);
  };

  const handleCancel = () => {
    setIsModalOpen(false);
  };

  return (
    <div style={{ width: "1155px", margin: "0 auto" }}>
      <div
        style={{
          display: "flex",
          alignItems: "center",
          width: 193,
          margin: "19px 0",
        }}
        onClick={toggleHandler}
      >
        <h2
          style={{
            marginBottom: "24px",
            lineHeight: "50px",
            fontSize: "20px",
            color: "#868686",
            marginRight: "10px",
          }}
        >
          우편번호
        </h2>
        <Form.Item valuePropName="zipCode">
          <Input
            style={{ width: 193, height: 50 }}
            value={item ? item.zipCode : zonecode}
          />
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
            <h2>우편검색</h2>
          </Button>
        </Form.Item>
      </div>

      {isOpen && (
        <Modal
          title="Basic Modal"
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

      <div style={{ marginTop: "2rem" }}>
        <h2 style={{ fontSize: "15px", color: "#868686" }}>기본주소</h2>
      </div>
      <Form.Item valuePropName="address">
        <Input
          style={{ width: 1155, height: 50 }}
          value={item ? item.address : address}
        />
      </Form.Item>
      <h2 style={{ fontSize: 15, color: "#868686" }}>상세주소</h2>
      <Form.Item name="addressDetail">
        <MyInputDetail onChange={inputChangeHandler} />
      </Form.Item>
    </div>
  );
};

export default AddressDetail;
