import React from "react";

export const LinkCopy = () => {
  var url = "";
  var textarea = document.createElement("textarea");
  document.body.appendChild(textarea);
  url = window.document.location.href;
  textarea.value = url;
  textarea.select();

  document.body.removeChild(textarea);
  alert("URL이 복사되었습니다.");
};

export default LinkCopy;
