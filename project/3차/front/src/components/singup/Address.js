import { Button, Form, Input, Modal } from "antd";
import React, { useEffect, useState } from "react";
import DaumPostcode from "react-daum-postcode";
import { useRecoilState } from "recoil";
import { Common } from "../../styles/CommonCss";
import { postCodeStyle, themeObj } from "../../styles/sign/signArea";
import { addressState } from "../../atom/addressState";

const Address = ({ onAddressChange, address:oladdress }) => {
  const [address, setAddress] = useRecoilState(addressState);
  const [last, setLast] = useState("");
  const [isOpen, setIsOpen] = useState(false);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [values, setValues] = useState({}); // values 객체 추가

  useEffect(()=>{
    setAddress(oladdress);
  },[]);

  const completeHandler = data => {
    const { address, zonecode } = data;

    setAddress(address);
    setLast(address); // lastaddress를 address와 동일하게 설정
    onAddressChange({ zonecode, address, last: address }); // lastaddress를 address와 동일하게 설정
    setIsOpen(false);

    // 주소 정보를 values 객체에 추가
    setValues(prevValues => ({
      ...prevValues,
      address: address,
    }));
  };

  // 주소 입력 변경 핸들러
  const inputChangeHandler = event => {
    setAddress({ ...address, last: event.target.value }); // Recoil 상태 업데이트
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
            value={address}
            placeholder="주소"
            name="address"
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
