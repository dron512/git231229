import React, { useEffect, useRef, useState } from "react";

// Import Swiper
import { Swiper, SwiperSlide } from "swiper/react";
import "swiper/css";
import "swiper/css/navigation";
import { Navigation } from "swiper/modules";

// import required modules
import { getBeforeList } from "../../api/mainpage/mainPageApi";
import useCustomLogin from "../../hooks/useCustomLogin";
import {
  ItemDecArea,
  ItemImg,
  ItemPacket,
  ItemTagBoxDiv,
  ItemTitlePrice,
  RcSwiperWrap,
  ReviewWish,
  TextArea,
} from "../../styles/mainstyle";
import MainHeartBt from "./MainHeartBt";
import MainItemBoxTag from "./MainItemBoxTag";
import { API_SERVER_HOST } from "../../util/util";

const initState = [
  {
    iproduct: 0,
    productNm: "",
    price: 0,
    rcFl: 0,
    popFl: 0,
    newFl: 0,
    reviewCnt: 0,
    likeProduct: 0,
    repPic: "",
  },
];

const MainNoneLoginSwiper = () => {
  const [data, setData] = useState(initState);
  const swiperRef = useRef(null);

  // 패스이동 =========================================
  const { moveToPath, moveToObj } = useCustomLogin();
  const moveToProduct = item => {
    moveToObj(`/item/${item.iproduct}?page=1`);
    // console.log(item.iproduct);
  };
  // 패스이동 =========================================
  useEffect(() => {
    // 데이터 연동 처리 결과

    const successFn = result => {
      setData(result);
      // console.log("잘나와용");
    };
    const failFn = result => {
      // console.log("실패했어용");
    };
    const errorFn = result => {
      // console.log("에러에옹", result);
    };
    getBeforeList({ successFn, failFn, errorFn });
  }, []);

  if (!setData) {
    return <p>Loading...</p>;
  }

  return (
    <div>
      <div>
        <TextArea>
          <span>
            육아 3회차 베테랑 MD가 추천하는
            <br />
          </span>
          <i>🔍 MD 추천상품 🔍</i>
        </TextArea>

        <RcSwiperWrap>
          <div
            style={{
              width: "1150px",
              position: "relative",
              display: "flex",
              justifyContent: "space-between",
            }}
            className="NoneLoginSwiperDiv"
          >
            <Swiper
              onSwiper={swiper => {
                swiperRef.current = swiper;
              }}
              navigation={{
                nextEl: ".NoneLoginSwiperDiv .slide-next-bt",
                prevEl: ".NoneLoginSwiperDiv .slide-prev-bt",
              }}
              modules={[Navigation]}
              className="mainSlideSett"
              slidesPerView={4}
              slidesPerGroup={4}
            >
              {data.map(item => (
                <SwiperSlide
                  key={item.iproduct}
                  style={{ width: "230px", height: "330px" }}
                  className="slotWidthSett"
                >
                  <ItemPacket>
                    <ItemImg
                      onClick={() => {
                        moveToProduct(item);
                      }}
                    >
                      <img
                        src={
                          item.repPic === ""
                            ? process.env.PUBLIC_URL +
                              "/assets/images/defaultitemimg.svg"
                            : `${API_SERVER_HOST}/pic/product/${item.iproduct}/${item.repPic}`
                        }
                      />
                    </ItemImg>
                    <ItemDecArea>
                      <ItemTagBoxDiv
                        onClick={() => {
                          moveToProduct(item);
                        }}
                      >
                        {item.popFl ? (
                          <MainItemBoxTag txt={"인기상품"} type={1} />
                        ) : null}
                        {item.newFl ? (
                          <MainItemBoxTag txt={"신상품"} type={2} />
                        ) : null}
                      </ItemTagBoxDiv>
                      <ReviewWish>
                        <div
                          onClick={() => {
                            moveToProduct(item);
                          }}
                        >
                          <span>리뷰</span>
                          <b>
                            {item.reviewCnt > 99 ? 99 + "+" : item.reviewCnt}
                          </b>
                        </div>
                        <MainHeartBt item={item} />
                      </ReviewWish>
                    </ItemDecArea>
                    <ItemTitlePrice>
                      <p>{item.productNm}</p>
                      <b>{item.price.toLocaleString()}원</b>
                    </ItemTitlePrice>
                  </ItemPacket>
                </SwiperSlide>
              ))}
            </Swiper>
            <button className="slide-prev-bt">
              <img
                src={process.env.PUBLIC_URL + "/assets/images/slidebt.svg"}
                alt=""
              />
            </button>
            <button className="slide-next-bt">
              <img
                src={process.env.PUBLIC_URL + "/assets/images/slidebt.svg"}
                alt=""
              />
            </button>
          </div>
        </RcSwiperWrap>
      </div>
    </div>
  );
};

export default MainNoneLoginSwiper;
