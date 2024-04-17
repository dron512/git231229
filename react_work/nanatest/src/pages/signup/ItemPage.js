import Icon from "@ant-design/icons/lib/components/Icon";
import { Button, Modal } from "antd";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import {
  getProduct,
  getwish,
  postCart,
  postOrder,
  putWish,
} from "../../api/signupapi/SignupApi";
import PrettyCounter from "../../components/Count";
import ImgSwiper from "../../components/signup/ImgSwiper";
import useCustomMove from "../../hooks/useCustomMove";
import {
  ItemHeart,
  ItemHover,
  ItemInfo,
  ItemMain,
  ItemPrice,
  ItemWrap,
  StyledButton,
  StyledDiv,
} from "../../styles/signup/item";
import ResultModal from "../../components/signup/ResultModal";
import { API_SERVER_HOST } from "../../util/util";

const ItemPage = () => {
  const { iproduct } = useParams();
  const { moveToItem, page } = useCustomMove();
  const [reviews, setReviews] = useState([
    {
      id: 1,
      user: "육아천재꼬물이엄마",
      pic: "https://i.namu.wiki/i/WGsJjdq_YZ55OqLwDcVy03tPUDeuy2bFGjbv7hGdqeTxhugt9oQVd9skQTplZArzk64Id35mmLbkbcMwWEo2-g.webp",
      text: "우리 꼬물이가 벌써부터 포크말고 젓가락 연습을 하는 날이 오다니 정말 기대되네요. 꼬물이가 좋아하는 뽀로로라서 구매를 하게 되었고 꽤 높은 곳에서 떨어뜨렸는데 멀쩡해요. 안심하고 막 사용해도 괜찮을 것 같네요. 이제 막 포크에서 젓가락으로 넘어가려는 애기엄마라면 무조건 강추입니당. 열심히 젓가락질 하려고 하는 모습이 기특해서 사진을 얼마나 찍었는지요~ 사진을 두장밖에 못넣어서 아쉽네용 ㅎㅎ.",
      rating: 5,
      date: "2024-01-09",
    },
    {
      id: 2,
      user: "육아천재꼬물이엄마",
      pic: "https://i.namu.wiki/i/WGsJjdq_YZ55OqLwDcVy03tPUDeuy2bFGjbv7hGdqeTxhugt9oQVd9skQTplZArzk64Id35mmLbkbcMwWEo2-g.webp",
      text: "고품질이며 가격 대비 훌륭합니다.",
      rating: 4,
      date: "2024-01-08",
    },
    {
      id: 3,
      user: "육아천재꼬물이엄마",
      pic: "https://i.namu.wiki/i/WGsJjdq_YZ55OqLwDcVy03tPUDeuy2bFGjbv7hGdqeTxhugt9oQVd9skQTplZArzk64Id35mmLbkbcMwWEo2-g.webp",
      text: "빠른 배송 서비스에 감사드립니다.",
      rating: 5,
      date: "2024-01-05",
    },
    {
      id: 4,
      user: "육아천재꼬물이엄마",
      pic: "https://i.namu.wiki/i/WGsJjdq_YZ55OqLwDcVy03tPUDeuy2bFGjbv7hGdqeTxhugt9oQVd9skQTplZArzk64Id35mmLbkbcMwWEo2-g.webp",
      text: "상품 너무 별로네요.",
      rating: 2,
      date: "2024-01-04",
    },
    {
      id: 5,
      user: "육아천재꼬물이엄마",
      pic: "https://i.namu.wiki/i/WGsJjdq_YZ55OqLwDcVy03tPUDeuy2bFGjbv7hGdqeTxhugt9oQVd9skQTplZArzk64Id35mmLbkbcMwWEo2-g.webp",
      text: "배송이 너무 느려요.",
      rating: 3,
      date: "2024-01-02",
    },
  ]);

  const navigate = useNavigate();

  const [selectedSection, setSelectedSection] = useState("productInfo");
  const showProductInfo = () => {
    setSelectedSection("productInfo");
  };

  const showPurchaseInfo = () => {
    setSelectedSection("purchaseInfo");
  };

  const showReviews = () => {
    setSelectedSection("reviews");
  };

  const sortReviewsByDate = () => {
    const sortedReviews = [...reviews].sort(
      (a, b) => new Date(b.date) - new Date(a.date),
    );
    setReviews(sortedReviews);
    // console.log(sortedReviews);
  };

  const sortReviewsByRatingHigh = () => {
    const sortedReviews = [...reviews].sort((a, b) => b.rating - a.rating);
    setReviews(sortedReviews);
  };

  const sortReviewsByRatingLow = () => {
    const sortedReviews = [...reviews].sort((a, b) => a.rating - b.rating);
    setReviews(sortedReviews);
  };
  const HeartSvg = () => (
    <svg width="4em" height="4em" fill="currentColor" viewBox="0 0 1024 1024">
      <path d="M923 283.6c-13.4-31.1-32.6-58.9-56.9-82.8-24.3-23.8-52.5-42.4-84-55.5-32.5-13.5-66.9-20.3-102.4-20.3-49.3 0-97.4 13.5-139.2 39-10 6.1-19.5 12.8-28.5 20.1-9-7.3-18.5-14-28.5-20.1-41.8-25.5-89.9-39-139.2-39-35.5 0-69.9 6.8-102.4 20.3-31.4 13-59.7 31.7-84 55.5-24.4 23.9-43.5 51.7-56.9 82.8-13.9 32.3-21 66.6-21 101.9 0 33.3 6.8 68 20.3 103.3 11.3 29.5 27.5 60.1 48.2 91 32.8 48.9 77.9 99.9 133.9 151.6 92.8 85.7 184.7 144.9 188.6 147.3l23.7 15.2c10.5 6.7 24 6.7 34.5 0l23.7-15.2c3.9-2.5 95.7-61.6 188.6-147.3 56-51.7 101.1-102.7 133.9-151.6 20.7-30.9 37-61.5 48.2-91 13.5-35.3 20.3-70 20.3-103.3 0.1-35.3-7-69.6-20.9-101.9z" />
    </svg>
  );

  const [productData, setProductData] = useState([]);

  const [purchase, setPurchase] = useState(false);

  const [isHeartChecked, setHeartChecked] = useState(
    productData.likeProduct === 1,
  );

  const handleClickHeart = async item => {
    const newValue = !isHeartChecked ? 1 : 0;
    setHeartChecked(!isHeartChecked);

    // console.log(newValue);

    setPurchase(!purchase);
    try {
      const response = await putWish({ iproduct: item });
      // console.log("putWish 함수에서 받은 응답:", response);
    } catch (error) {
      // console.log(error);
    }
  };

  const HeartIcon = props => <Icon component={HeartSvg} {...props} />;
  // console.log(productData.price);
  // console.log(productData.iproduct);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const result = await getProduct(iproduct, page);
        // setProductData(...result);
        setProductData(result);
      } catch (error) {
        alert("데이터 호출에 실패하였습니다.");
      }
    };
    fetchData();
  }, [productData.likeProduct]);

  // console.log(productData);
  const [count, setCount] = useState(1);
  // console.log(count);

  // 장바구니 버튼
  const handleClickModal = () => {
    showModal();
    setModealShow(true);
  };

  const [isOpen, setIsOpen] = useState(false);

  const showModal = () => {
    setIsOpen(true);
    setTitleResult("장바구니");

    setModalMessage(
      <>
        <p>장바구니에 상품을 담겠습니까?</p>
        <p>확인 누를 시 장바구니로 이동합니다.</p>
      </>,
    );
  };

  const handleOk = () => {
    setIsOpen(false);
    const cart = {
      iproduct: productData.iproduct,
      productCnt: count,
    };
    postCart(cart);
    navigate("/cart");
  };

  const handleCancel = () => {
    setIsOpen(false);
    const cart = {
      iproduct: productData.iproduct,
      productCnt: count,
    };
    postCart(cart);
  };

  const handleClickadd = () => {
    const productOrder = {
      products: [
        {
          iproduct: productData.iproduct,
          productCnt: count,
          productTotalPrice: productData.price * count,
        },
      ],
      totalOrderPrice: productData.price * count,
    };
    postOrder({
      productOrder,
      successFn,
      failFn,
      errorFn,
    });
    navigate(`/payment`, { state: { ...serverResult } });
  };

  const [serverResult, setServerResult] = useState(null);
  const successFn = result => {
    setServerResult(result);
  };

  const failFn = result => {};

  const errorFn = result => {};

  const addComma = price => {
    let returnString = price?.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    return returnString;
  };
  const price = addComma(productData.price * count);
  const [titleResult, setTitleResult] = useState("");
  const [modalMessage, setModalMessage] = useState("");
  const [modalShow, setModealShow] = useState(false);

  const modalClose = () => {
    setIsOpen(false);
    handleOk();
  };
  const modalCancel = () => {
    setIsOpen(false);
    handleCancel();
  };
  let imgUrl = `/pic/product/${iproduct}/`;
  let imgreviewUrl = `/pic/review/${iproduct}/`;

  return (
    <ItemMain>
      <ItemWrap>
        <div style={{ width: "600px", height: "520px" }}>
          <ImgSwiper productData={productData} iproduct={iproduct} />
        </div>
        <div style={{ width: "800px" }}>
          <div style={{ paddingBottom: 220 }}>
            <ItemHover>
              <div className="itemtext">{productData.productNm}</div>
              <ItemHeart onClick={() => handleClickHeart(productData.iproduct)}>
                <HeartIcon
                  style={
                    productData.likeProduct
                      ? { color: "red" }
                      : { color: "#D9D9D9" }
                  }
                />
              </ItemHeart>
            </ItemHover>
            <span className="itemspan">
              평점 <span>{productData.scoreAvg}</span> 리뷰{" "}
              <sapn>{productData.reviewCnt}</sapn>
            </span>
          </div>
          <ItemPrice>
            <div>
              <PrettyCounter
                name="productCnt"
                setCount={setCount}
                count={count}
              />
            </div>
            <div>
              <div className="itemFree">무료배송</div>
              <div className="itemOnePrice">
                {count}개 <b>{price}</b> <sapn>원</sapn>
              </div>
            </div>
          </ItemPrice>

          <Button
            onClick={handleClickModal}
            type="primary"
            htmlType="submit"
            style={{
              backgroundColor: "#FFF",
              border: "1px solid #D68000 ",
              color: "#D68000",
              width: "48%",
              height: 50,
              fontWeight: "bold",
              marginRight: "20px",
              marginTop: "20px",
            }}
          >
            장바구니
          </Button>
          {isOpen && (
            <ResultModal
              title={titleResult}
              message={modalMessage}
              callFN={modalClose}
              btchange={false}
              cancelFN={modalCancel}
            />
          )}
          <Button
            type="primary"
            style={{
              backgroundColor: "#D68000",
              color: "#FFFFFF",
              border: "none",
              fontWeight: "bold",
              width: "48%",
              height: 50,
            }}
            onClick={handleClickadd}
          >
            바로구매
          </Button>
        </div>
      </ItemWrap>
      <div>
        <ItemInfo>
          <div
            onClick={() => {
              showProductInfo();
            }}
          >
            상품정보
          </div>
          <div
            onClick={() => {
              showPurchaseInfo();
            }}
          >
            구매안내
          </div>
          <div
            onClick={() => {
              showReviews();
            }}
          >
            리뷰
          </div>
        </ItemInfo>
        {selectedSection === "productInfo" && (
          <div style={{ textAlign: "center", margin: "100px 0" }}>
            {/* 상품 정보 표시 */}

            <img style={{}} src={imgUrl + productData.productDetails} />
          </div>
        )}
        {selectedSection === "purchaseInfo" && (
          <div style={{ textAlign: "center", margin: "100px 0" }}>
            {/* 구매 안내 표시 */}
            <img
              style={{ height: "1000px" }}
              src={process.env.PUBLIC_URL + "/assets/images/itemguidebook.svg"}
            />
          </div>
        )}
        {selectedSection === "reviews" && (
          <div
            style={{ borderBottom: "1px solid #868686", paddingBottom: "50px" }}
          >
            {/* 리뷰 표시 */}
            <div style={{ margin: "100px 0" }}>
              <StyledDiv>
                <div className="reviewtext">
                  <div>
                    {productData.productNm}
                    <div className="reviewtotal">
                      리뷰 총 <span>{productData.reviewCnt}</span> 개
                    </div>
                  </div>
                </div>

                <div
                  style={{
                    width: 472,
                    height: 108,
                    color: "#E9B25F",
                    background: "#FFF7EC",
                    textAlign: "center",
                    display: "flex",
                    justifyContent: "center",
                    alignItems: "center",
                    fontSize: "7rem",
                    fontWeight: 900,
                  }}
                >
                  <span>평점 {productData.scoreAvg}</span>
                </div>
              </StyledDiv>
              <div
                style={{ margin: "0 auto", width: "1220px", marginTop: "25px" }}
              >
                <div>
                  <StyledButton>최신순</StyledButton>
                  <StyledButton>평점높은순</StyledButton>
                  <StyledButton>평점낮은순</StyledButton>
                </div>
                <ul>
                  {productData.reviewSelVo.map((review, ireview) => (
                    <li key={ireview}>
                      <div>
                        <div
                          style={{
                            display: "flex",
                            justifyContent: "space-between",
                            paddingTop: "40px",
                          }}
                        >
                          <div
                            style={{
                              color: "#868686",
                              fontFamily: "Noto Sans KR",
                              fontSize: "30px",
                              fontStyle: "normal",
                              fontWeight: 400,
                              lineHeight: "normal",
                            }}
                          >
                            {review.nm}
                            <sapn
                              style={{
                                paddingLeft: "10px",
                                color: "#E9B25F",
                                fontFamily: "Noto Sans KR",
                                fontSize: "30px",
                                fontStyle: "normal",
                                fontWeight: 700,
                                lineHeight: "normal",
                              }}
                            >
                              {review.productScore}점
                            </sapn>
                          </div>

                          <div
                            style={{
                              color: "#868686",
                              textAlign: "right",
                              fontFamily: "Noto Sans KR",
                              fontSize: "30px",
                              fontStyle: "normal",
                              fontWeight: 400,
                              lineHeight: "normal",
                            }}
                          >
                            {review.createdAt}
                          </div>
                        </div>
                        <div
                          style={{
                            display: "flex",
                            gap: "40px",
                            paddingTop: "30px",
                          }}
                        >
                          <div>
                            <img
                              src={`${API_SERVER_HOST}/pic/review/${review.ireview}/${review.pics[0]}`}
                              style={{ width: "300px", height: "200px" }}
                            />
                          </div>
                          <div
                            style={{
                              color: "#595959",
                              textAlign: "justify",
                              fontFamily: "Noto Sans KR",
                              fontSize: "25px",
                              fontStyle: "normal",
                              fontWeight: 400,
                              lineHeight: "30px" /* 120% */,
                            }}
                          >
                            <p>{review.contents}</p>
                          </div>
                        </div>
                      </div>
                    </li>
                  ))}
                </ul>
              </div>
            </div>
          </div>
        )}
      </div>
    </ItemMain>
  );
};

export default ItemPage;
