// import { useState } from "react";

// const [aa, setAa] = useState("Hello");
// const [board, setBoard] = useState([]);
// const [content, setContent] = useState("초기값");
// const doA = () => {
//     if (aa === "Hello")
//         setAa("World");
//     else
//         setAa("Hello");
// }
// const doB = () => {
//     fetch("http://two.hellomh.site/board/list")
//         .then(response => response.json())
//         .then(data => setBoard(data));
// }
// const doC = () => {
//     const num = Math.floor(Math.random()*3+1);
//     console.log("여기오나"+num);
//     fetch("http://two.hellomh.site/board/view/"+num)
//         .then(response => response.json())
//         .then(data => {
//             console.log(data);
//             setContent(data.content);
//         });
// }
// export default ()=>{
//     return {
//         aa,
//         board,
//         content,
//         doA,
//         doB,
//         doC,
//     };
// }