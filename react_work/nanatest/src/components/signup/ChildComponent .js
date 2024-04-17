// ChildComponent.js
import React, { useState } from "react";
import { Radio, Button, Form } from "antd";

const ChildComponent = ({ onSelet, name, valueArray }) => {
  // const [modifyArray,setModifyArray] =useState([]);
  // console.log(valueArray);
  // console.log(name);
  // console.log([name, "ichildAge"]);

  return (
    <div>
      <div style={{ paddingTop: 30 }}>월령/개월 수*</div>
      <Form.Item name={[name, "ichildAge"]} style={{ height: 50 }}>
        <Radio.Group
          style={{
            width: "1220px",
            display: "flex",
            paddingBottom: "50px",
          }}
        >
          <Radio.Button
            value={1}
            style={{
              height: 50,
              width: "25%",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            임신/출산 (~0개월)
          </Radio.Button>
          <Radio.Button
            value={2}
            style={{
              height: 50,
              width: "25%",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            신생아 (1~3개월)
          </Radio.Button>
          <Radio.Button
            value={3}
            style={{
              height: 50,
              width: "25%",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            베이비 (4~23개월)
          </Radio.Button>
          <Radio.Button
            value={4}
            style={{
              height: 50,
              width: "25%",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            키즈(24개월~)
          </Radio.Button>
        </Radio.Group>
      </Form.Item>

      <div>우리아이 성별*</div>
      <div
        style={{
          display: "flex",
          justifyContent: "space-between",
          borderBottom: "3px solid #C5C5C5",
        }}
      >
        <Form.Item name={[name, "gender"]} style={{ paddingBottom: 50 }}>
          <Radio.Group style={{ display: "flex" }}>
            <Radio.Button value="M" style={{ height: 50, lineHeight: "50px" }}>
              남
            </Radio.Button>
            <Radio.Button value="W" style={{ height: 50, lineHeight: "50px" }}>
              여
            </Radio.Button>
          </Radio.Group>
        </Form.Item>
        <Form.Item>
          <Button
            type="default"
            style={{
              border: "1px solid #FF4E4E ",
              color: "#FF4E4E",
              backgroundColor: "#FFFFFF",
              width: "115px",
              height: "50px",
              marginTop: "1rem", // 추가: 버튼 위 간격 조절을 위한 속성
            }}
            onClick={onSelet}
          >
            삭제하기
          </Button>
        </Form.Item>
      </div>
    </div>
  );
};

export default ChildComponent;
