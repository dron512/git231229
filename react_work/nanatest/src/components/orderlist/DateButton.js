import React, { useState } from "react";

const DateButton = () => {
  const [selectedDate, setSelectedDate] = useState();
  let today = new Date();
  let newDay = new Date(today);

  newDay.setMonth(today.getMonth() - 2);
  // console.log({ newDay });

  const handButtonClick = () => {
    setSelectedDate();
    // console.log(handButtonClick);
  };
  return (
    <div>
      <button onClick={handButtonClick}>오늘</button>
      <button>1주일</button>
      <button>1개월</button>
      <button>3개월</button>
      <button>6개월</button>
    </div>
  );
};

export default DateButton;
