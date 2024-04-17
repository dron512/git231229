export const getNum = (check, basic) => {
  if (!check) {
    return basic;
  }
  return check;
};

// 추후에 우리꺼에 맞춰서 양식에 바꿔서 수정예정
// const handleChange = e => {
//     // e.target.name
//     // e.target.value
//     loginParam[e.target.name] = e.target.value;
//     setLoginParm({ ...loginParam });
//   };

// 초기값 설정도 추후 수정예정
// const initState = {
//     email: "",
//     pw: "",
// }

export const API_SERVER_HOST = "";
