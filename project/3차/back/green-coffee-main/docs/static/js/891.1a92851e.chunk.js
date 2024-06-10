"use strict";(self.webpackChunkpwa=self.webpackChunkpwa||[]).push([[891],{6013:(n,e,t)=>{t.d(e,{B:()=>a,Z:()=>o});var i=t(9802);const o=async n=>{try{const e=await i.Ay.get("/homeAd/event");n(e.data)}catch(e){console.log(e)}},a=async n=>{try{const e=(await i.Ay.get("/recommend/")).data;n(e),console.log(e)}catch(e){console.log(e)}}},5891:(n,e,t)=>{t.r(e),t.d(e,{default:()=>w});var i=t(9950),o=t(6013),a=t(2074),r=t(18),l=t(4414);const d=n=>{let{eventData:e}=n;return console.log("eventData",e),(0,l.jsx)(r.O,{children:e.map(((n,e)=>(0,l.jsx)("div",{children:(0,l.jsx)(a.N_,{to:"/eventdetail",state:{eventInfo:n},children:n.imageUrl.split("/").pop().split(".").slice(0,-1).join(".").split(8).pop()})},e)))})};var p,s,m,c,g=t(7528),h=t(6751);const x=h.A.div(p||(p=(0,g.A)(["\n  width: 100%;\n  padding: 1.875rem 0;\n"]))),f=h.A.div(s||(s=(0,g.A)(["\n  .home-logo {\n    width: 100%;\n    height: 150px;\n    margin-bottom: 20px;\n    display: flex;\n    justify-content: center;\n    align-items: center;\n    font-size: 25px;\n    > img {\n      width: 100%;\n      height: 150px;\n    }\n  }\n"]))),w=(h.A.div(m||(m=(0,g.A)(["\n  width: 100%;\n  margin-bottom: 20px;\n  > .inner {\n    width: 100%;\n    display: flex;\n    flex-direction: column;\n    h3 {\n      width: 100%;\n      margin-bottom: 8px;\n    }\n    .swiper-wrap {\n      width: 100%;\n      height: 150px;\n      border-radius: 20px;\n      .swiper-slide {\n        div {\n          > img {\n            width: 100%;\n            height: 150px;\n            object-fit: cover;\n          }\n        }\n      }\n      .swiper-button-next {\n        display: none;\n      }\n      .swiper-button-prev {\n        display: none;\n      }\n    }\n  }\n"]))),h.A.div(c||(c=(0,g.A)(["\n  width: 100%;\n  > .inner {\n    h3 {\n      margin-bottom: 15px;\n    }\n    .content {\n      display: flex;\n      justify-content: space-between;\n      align-items: center;\n      flex-wrap: wrap;\n      gap: 20px;\n      width: 100%;\n      ul {\n        display: flex;\n        justify-content: center;\n        align-items: center;\n        flex-direction: column;\n        gap: 20px;\n        width: calc(33.333% - 20px);\n        li {\n          :first-of-type {\n            width: 100%;\n            display: flex;\n            justify-content: center;\n            align-items: center;\n            border-radius: 30px;\n            box-shadow: 3px 8px 5px 1px rgba(51, 51, 51, 0.2);\n            overflow: hidden;\n            img {\n              width: 100%;\n              height: 100%;\n              border-radius: 30px;\n              transition: transform 0.5s ease-in-out;\n            }\n            img:hover {\n              transform: scale(1.1);\n            }\n          }\n          :last-of-type {\n            padding-top: 0.625rem;\n            display: flex;\n            flex-direction: column;\n            align-items: center;\n            font-size: 14px;\n            font-weight: 700;\n          }\n        }\n      }\n    }\n  }\n"]))),()=>{const[n,e]=(0,i.useState)([]);return(0,i.useEffect)((()=>{(0,o.Z)(e)}),[]),console.log("eventData",n),(0,l.jsx)(x,{children:(0,l.jsx)(f,{children:(0,l.jsx)(d,{eventData:n})})})})},18:(n,e,t)=>{t.d(e,{O:()=>p,W:()=>d});var i,o,a=t(7528),r=t(6751),l=t(6066);const d=r.A.div(i||(i=(0,a.A)(["\n  padding-top: 30px;\n  margin: 0;\n  width: 100%;\n  > div {\n    color: ",";\n    :nth-of-type(1) {\n      display: flex;\n      justify-content: center;\n      align-items: center;\n      font-size: 20px;\n      color: ",";\n      padding-bottom: 20px;\n    }\n    :nth-of-type(2) {\n      padding: 0 0 5px 10px;\n    }\n    :nth-of-type(3) {\n      padding: 0 0 50px 10px;\n    }\n  }\n"])),l.Tj.black,l.Tj.main),p=r.A.div(o||(o=(0,a.A)(["\n  width: 100%;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n  flex-wrap: wrap;\n  gap: 30px;\n  color: ",";\n  & div {\n    display: flex;\n    align-items: center;\n    width: 100%;\n    font-size: 20px;\n    border-bottom: 1px solid ",";\n    padding: 0 0 10px 15px;\n    a {\n      width: 100%;\n    }\n    :last-of-type {\n      margin-bottom: 5px;\n      span {\n        width: 100%;\n        cursor: pointer;\n      }\n    }\n  }\n"])),l.Tj.black,l.Tj.disabled)},6066:(n,e,t)=>{t.d(e,{Tj:()=>u,gO:()=>b});var i,o,a,r,l,d,p,s,m,c,g,h=t(7528),x=t(6751);const f="@media only screen and (max-width: 1024px)",w="@media only screen and (max-width: 769px)",u={bar:"#F7F7F7",main:"#BF8A30",point:"#6A1B1B",green:"#009E73",red:"#EB5757",black:"#444444",white:"#ffffff",disabled:"#D9D9D9"},b={line1:{overflow:"hidden",whiteSpace:"nowrap",textOverflow:"ellipsis"},line2:{overflow:"hidden",whiteSpace:"normal",textOverflow:"ellipsis",display:"-webkit-box",WebkitLineClamp:"2",WebkitBoxOrient:"vertical"},line3:{overflow:"hidden",whiteSpace:"normal",textOverflow:"ellipsis",display:"-webkit-box",WebkitLineClamp:"3",WebkitBoxOrient:"vertical"}};x.A.div(i||(i=(0,h.A)(["\n  max-width: ",";\n  /* height: 100vh; */\n  display: flex;\n  flex-direction: column;\n  margin: 0 auto;\n\n  input,\n  textarea {\n    border: 1px solid ",";\n    border-radius: 1rem;\n    font-size: 1.2rem;\n  }\n\n  input::placeholder,\n  textarea::placeholder {\n    color: ",";\n  }\n"])),(n=>{n.maxw}),u.secondary,u.placeholder),x.A.div(o||(o=(0,h.A)(["\n  position: relative;\n  width: 100%;\n  padding: 0 2%;\n  background-color: ",";\n  display: flex;\n  height: 7.5rem;\n  justify-content: right;\n  align-items: center;\n  gap: 2rem;\n  z-index: 14;\n  border-bottom: 1px solid ",";\n  p {\n    font-size: 1.8rem;\n    color: ",";\n  }\n  .nav-logo {\n    width: 10rem;\n    display: block;\n    margin-right: auto;\n    display: none;\n    img {\n      width: 100%;\n    }\n  }\n  "," {\n    .nav-logo {\n      display: block;\n      margin-left: 3rem;\n    }\n  }\n"])),u.white,u.grayLight,u.greenDeep,w),x.A.div(a||(a=(0,h.A)(["\n  display: flex;\n  justify-content: flex-end;\n  align-items: center;\n  gap: 1rem;\n  "," {\n    .nav-btn {\n      display: none;\n    }\n  }\n"])),w),x.A.div(r||(r=(0,h.A)(["\n  position: relative;\n  padding: 3rem 2% 0;\n  height: calc(100vh - 7.5rem);\n  overflow-y: auto;\n  background: #fff\n    url(",") repeat top;\n"])),"/images/common/background.png"),x.A.div(l||(l=(0,h.A)(["\n  position: relative;\n  min-height: 100%;\n  margin: 0 auto 8rem;\n  z-index: 12;\n\n  input::placeholder,\n  textarea::placeholder {\n    color: ",";\n  }\n"])),u.placeholder),x.A.div(d||(d=(0,h.A)(["\n  max-width: 1300px;\n  margin: 0 auto;\n"]))),x.A.div(p||(p=(0,h.A)(["\n  background: #fff;\n  z-index: 99;\n  ","\n  "," {\n    .ant-menu-inline .ant-menu-submenu-title,\n    .ant-menu-light.ant-menu-inline .ant-menu-item {\n      padding: 1rem !important;\n    }\n    .ant-layout-sider {\n      min-width: auto !important;\n      width: 20rem !important;\n    }\n    .ant-layout-sider-collapsed {\n      min-width: 50px !important;\n      width: 50px !important;\n    }\n  }\n  "," {\n    position: absolute;\n    height: 100%;\n    left: 0;\n    top: 0;\n    .ant-layout-sider-collapsed {\n      min-width: 0 !important;\n      width: 0 !important;\n      img {\n        display: none;\n      }\n    }\n  }\n"])),{boxShadow:"0px 0px 5px 0px rgba(0, 0, 0, 0.1)",border:"1px solid rgba(0,0,0,0.02)"},f,w),x.A.div(s||(s=(0,h.A)(["\n  width: 100%;\n  text-align: center;\n  margin: 3rem 0;\n  img {\n    max-height: 3.5rem;\n  }\n"]))),x.A.div(m||(m=(0,h.A)(["\n  position: fixed;\n  left: 0;\n  bottom: 0;\n  width: 100%;\n  z-index: 13;\n\n  a {\n    position: absolute;\n    left: 50%;\n    bottom: 0.4rem;\n    transform: translateX(-50%);\n    font-size: 1.3rem;\n    color: #fff;\n  }\n"]))),x.A.h3(c||(c=(0,h.A)(["\n  padding-left: 2.8rem;\n  background: url(",")\n    no-repeat left 0.25rem/2.3rem;\n  color: ",";\n  a {\n    color: ",";\n  }\n"])),"/images/information/logo1.svg",u.greenDeep,u.greenDeep),x.A.div(g||(g=(0,h.A)(["\n  width: 100%;\n  padding: 3rem 2rem;\n  font-size: 1.6rem;\n  border-radius: 1rem;\n  background: #f7f7f7;\n  margin: 2rem 0;\n  text-align: center;\n  border: 1px solid ",";\n\n  p {\n    margin-bottom: 2rem;\n    line-height: 1.5;\n  }\n  b {\n    font-size: 400;\n    color: ",";\n  }\n  small {\n    display: block;\n    margin-top: 0.5rem;\n    font-size: 1.4rem;\n    color: ",";\n  }\n  .ant-input-group-wrapper {\n    margin: 0 auto;\n    display: block;\n    max-width: 50rem;\n  }\n"])),u.grayBar,u.greenDeep,u.grayDeep)}}]);