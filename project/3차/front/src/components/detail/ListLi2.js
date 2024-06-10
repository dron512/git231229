import React from "react";

const ListLi2 = ({ content,nation }) => {
  return (
    <div>
      <ul>
        <li>도수 : {content}도</li>
        <li>국가 : {nation}</li>
        {/* {items.map((item, index) => (
          <li key={index}>{item}</li>
        ))} */}
      </ul>
    </div>
  );
};

export default ListLi2;
