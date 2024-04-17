import React, { useState } from "react";

function Fi() {
  const [isActive, setIsActive] = useState(false);

  function handleClick() {
    setIsActive(!isActive);
  }

  return (
    <button className={isActive ? "active" : ""} onClick={handleClick}>
      Sort
    </button>
  );
}
