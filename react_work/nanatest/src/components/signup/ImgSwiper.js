import React, { useRef, useState } from "react";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";
// Import Swiper styles
import "swiper/css";
import "swiper/css/free-mode";
import "swiper/css/navigation";
import "swiper/css/thumbs";
import "../../styles/signup/styles.css";
// import required modules
import { FreeMode, Navigation, Thumbs } from "swiper/modules";
export default function ImgSwiper({ productData, iproduct }) {
  // console.log(productData);

  const [thumbsSwiper, setThumbsSwiper] = useState(null);
  let imgUrl = `/pic/product/${iproduct}/`;
  const imgProduct = productData.productPics || [];
  // console.log(imgProduct);

  return (
    <>
      <Swiper
        style={{
          "--swiper-navigation-color": "#fff",
          "--swiper-pagination-color": "#fff",
        }}
        loop={true}
        spaceBetween={10}
        navigation={true}
        thumbs={{ swiper: thumbsSwiper }}
        modules={[FreeMode, Navigation, Thumbs]}
        className="mySwiper2"
      >
        {imgProduct.map((item, index) => (
          <SwiperSlide key={index}>
            <img src={imgUrl + item} />
          </SwiperSlide>
        ))}
      </Swiper>
      <Swiper
        onSwiper={setThumbsSwiper}
        loop={true}
        spaceBetween={10}
        slidesPerView={4}
        freeMode={true}
        watchSlidesProgress={true}
        modules={[FreeMode, Navigation, Thumbs]}
        className="mySwiper"
      >
        {imgProduct.map((item, index) => (
          <SwiperSlide key={index}>
            <img src={imgUrl + item} />
          </SwiperSlide>
        ))}
      </Swiper>
    </>
  );
}
