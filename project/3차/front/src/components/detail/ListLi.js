import React from "react";

const ListLi = ({ taste,aroma,finish }) => {
  return (
    <div>
      <ul>
        <li>맛 : {taste}</li>
        <li>향 : {aroma}</li>
        <li>여운 : {finish}</li>
        {/* {items.map((item, index) => (
          <li key={index}>{item}</li>
        ))} */}
      </ul>
    </div>
  );
};

export default ListLi;
