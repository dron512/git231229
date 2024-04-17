import React, { useRef } from "react";
import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";
import "swiper/css/navigation";

// import required modules
import { Autoplay, Navigation } from "swiper/modules";
import { SwiperDiv } from "../../styles/mainstyle";

const MainSwiper = () => {
  const swiperRef = useRef(null);

  return (
    <SwiperDiv className="mainSwiperDiv">
      <Swiper
        modules={[Navigation, Autoplay]}
        className="mainSwiperPics"
        slidesPerView={1}
        autoplay={{ delay: 3000, disableOnInteraction: false }}
        onSwiper={swiper => {
          swiperRef.current = swiper;
        }}
        navigation={{
          nextEl: ".mainSwiperDiv .slide-next-bt",
          prevEl: ".mainSwiperDiv .slide-prev-bt",
        }}
        loop={true}
        speed={2000}
      >
        <SwiperSlide>
          <img
            src={process.env.PUBLIC_URL + "/assets/images/mainswiperimg1.svg"}
          />
        </SwiperSlide>
        <SwiperSlide>
          <img
            src={process.env.PUBLIC_URL + "/assets/images/mainswiperimg2.svg"}
          />
        </SwiperSlide>
        <SwiperSlide>
          <img
            src={process.env.PUBLIC_URL + "/assets/images/mainswiperimg3.svg"}
          />
        </SwiperSlide>
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
    </SwiperDiv>
  );
};

export default MainSwiper;
