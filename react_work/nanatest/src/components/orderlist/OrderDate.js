import React, { useState } from "react";
import { DatePicker, Space } from "antd";
const { RangePicker } = DatePicker;

const OrderDate = () => {
  // 상태(state)를 사용하여 선택된 날짜를 저장
  const [selectedDate, setSelectedDate] = useState(null);

  const handleDateChange = dates => {
    // 선택된 날짜가 변경될 때마다 호출되는 함수
    // console.log("선택된 날짜:", dates);

    // 변경된 날짜를 상태에 저장
    setSelectedDate(dates);
  };

  return (
    <Space direction="vertical" size={12}>
      <RangePicker onChange={handleDateChange} />
      {/* 선택된 날짜 출력 */}
      {selectedDate && (
        <div className="date">
          선택된 날짜: {selectedDate[0].format("YYYY-MM-DD")} ~{" "}
          {selectedDate[1].format("YYYY-MM-DD")}
        </div>
      )}
    </Space>
  );
};

export default OrderDate;
