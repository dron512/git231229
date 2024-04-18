import axios from "axios";

export const aaa=({data,setData})=>{
    console.log("aaa");
    console.log("data"+data);

    console.log(setData);
    // setData("바뀜");

    // axios.get("http://localhost:8080/api/test",{
    //     headers:{
    //         'Authorization': 'Bearer '+localStorage.getItem('token')
    //     }
    // }).then(res=>{
    //     return res.json();
    // })
    // .then(res=>{
    //     console.log(res.data);
    // })
    // .catch(err=>{
    //     console.log(err);
    // })
}