import { PlusOutlined } from "@ant-design/icons";
import { Button, ConfigProvider, Form, Modal, Rate, Upload } from "antd";
import TextArea from "antd/es/input/TextArea";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import {
  getProductReview,
  postReviewList,
} from "../../api/reviewapi/reviewAddApi";
import useCustomMove from "../../hooks/useCustomMove";
import {
  RateAddBox,
  ReviewAddTitle,
  ReviewAddWrap,
} from "../../styles/review/reviewstyle";
import { API_SERVER_HOST } from "../../util/util";
import {
  ModalButton,
  ModalPop,
  PaymentBody,
  PaymentFooter,
  PaymentHeader,
  PaymentWrap,
} from "../../styles/payment/paymentstyle";

const initState = [
  {
    reviewPics: [""], // 리뷰 사진
    dto: {
      idetails: 0, //   주문상세 KEY
      iorder: 0, //   주문 PK
      contents: "", //   리뷰 내용
      productScore: 0, //   리뷰 별점
    },
  },
];

const getBase64 = file =>
  new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => resolve(reader.result);
    reader.onerror = error => reject(error);
  });

const ReviewAddPageCom = () => {
  const [checkInfoPlz, setCheckInfoPlz] = useState(false);
  const { navigate } = useCustomMove();
  // console.log(useParams());
  // console.log(productData.iproduct);
  const { iproduct, idetails, iorder } = useParams();
  // 처리하셔야 합니다.
  const [page, setPage] = useState(1);

  // 아이템 불러오기
  const [productData, setProductData] = useState([]);

  // ================ 파일 업로드
  const [previewOpen, setPreviewOpen] = useState(false);
  const [previewImage, setPreviewImage] = useState("");
  const [previewTitle, setPreviewTitle] = useState("");
  const [fileList, setFileList] = useState([]);
  // 업로드할 이미지 모음
  const [uploadFileList, setUploadFileList] = useState([]);
  const [uploadImgFile, setUploadImgFile] = useState(null);

  // =========== 최초 자료 가져오기
  const getDetailInfo = () => {
    getProductReview(iproduct, page, { successFn, failFn, errorFn });
  };
  const successFn = result => {
    // console.log("성공", result);
    setProductData(result);
  };
  const failFn = result => {
    console.log("실패", result);
  };
  const errorFn = result => {
    console.log("서버오류", result);
  };

  useEffect(() => {
    getDetailInfo();
  }, [iproduct]);

  // =========== 폼데이터 보관하기
  const [formData, setFormData] = useState({
    // 여기에 폼의 각 필드에 대한 초기값을 설정하세요.
    reviewPics: [],
    dto: { idetails: idetails, contents: "", productScore: 0, iorder: iorder },
  });

  // Antd 이미지 업로드
  const normFile = e => {
    if (Array.isArray(e)) {
      return e;
    }
    return e?.fileList;
  };

  const handleScoreChange = (productScore, value) => {
    // console.log("별점", value);
    if (productScore === "productScore") {
      // 리뷰 별점인 경우, 값이 숫자로 변환되도록 처리
      value = parseFloat(value);
    }
    setFormData({
      ...formData,
      dto: {
        ...formData.dto,
        productScore: value,
      },
    });
    // console.log(formData.dto.productScore);
  };
  const handleContentsChange = (contents, value) => {
    setFormData({
      ...formData,
      dto: {
        ...formData.dto,
        contents: value,
      },
    });
    // console.log(formData);
  };

  //========= 파일전송
  const handleSubmit = async value => {
    const formData = new FormData();
    const dto = new Blob(
      [
        JSON.stringify({
          idetails: idetails,
          iorder: iorder,
          contents: value.contents,
          productScore: value.start,
        }),
      ],
      // JSON 형식으로 설정
      { type: "application/json" },
    );

    formData.append("dto", dto);
    const imagePromises = uploadFileList.map(async (image, index) => {
      const response = await fetch(image);
      const blob = await response.blob();
      const currentDate = new Date();
      const seconds = Math.floor(currentDate.getTime() / 1000);
      const file = new File([blob], `image${seconds}.jpg`, {
        type: "image/jpeg",
      });
      formData.append("reviewPics", file);
    });
    await Promise.all(imagePromises);

    // 아래에서 전송코드 실행
    postReviewList(iproduct, {
      paramData: formData,
      successFn: successFnPost,
      failFn: failFnPost,
      errorFn: errorFnPost,
    });
  };

  const successFnPost = result => {
    console.log("성공", result);
    navigate(`../review?page=1`);
  };
  const failFnPost = result => {
    console.log("실패", result);
  };
  const errorFnPost = result => {
    console.log("서버오류", result);
  };

  const onFinishFailed = errorInfo => {
    console.log("Failed:", errorInfo);
  };

  // =========== Ant 디자인 미리보기
  const handleCancel = () => setPreviewOpen(false);
  const handlePreview = async file => {
    if (!file.url && !file.preview) {
      file.preview = await getBase64(file.originFileObj);
    }
    setPreviewImage(file.url || file.preview);
    setPreviewOpen(true);
    setPreviewTitle(
      file.name || file.url.substring(file.url.lastIndexOf("/") + 1),
    );
  };

  // 파일 목록관리
  const handleChange = ({ fileList: newFileList }) => {
    // console.log("fileList", fileList);
    setFileList(newFileList);
    setUploadFileList([]);
  };

  // 서버에 보낼 이미지 목록을 파일로 보관하면서 담아둠
  const fileUpdate = () => {
    fileList.map(file => {
      if (file.originFileObj) {
        // 미리보기
        const tempUrl = URL.createObjectURL(file.originFileObj);
        console.log(tempUrl);
        // FB 파일을 보관
        setUploadImgFile(file.originFileObj); // 파일 1개 추가 끝
        setUploadFileList(prevImages => [...prevImages, tempUrl]);
      }
    });
  };
  useEffect(() => {
    fileUpdate();
  }, [fileList]);

  // 버튼 디자인
  const uploadButton = (
    <button
      style={{
        border: 0,
        background: "none",
      }}
      type="button"
    >
      <PlusOutlined />
      <div
        style={{
          marginTop: 8,
        }}
      >
        Upload
      </div>
    </button>
  );

  const callFN = () => {
    // 모달 닫기
    setCheckInfoPlz(false);
  };

  return (
    <ReviewAddWrap>
      {/* <ModalPop>
        <div
          style={{ background: "#fff", textAlign: "center", width: "200px" }}
        >
          <h1>작성완료 하시겠습니까 ?</h1>
          <ModalButton>
            <button onClick={callFN}>확인</button>
          </ModalButton>
        </div>
      </ModalPop> */}

      <div className="reviewBody">
        <ReviewAddTitle>
          <span>Review : 작성하기</span>
          <p>구매한 제품에 대해 리뷰해 주세요.</p>
        </ReviewAddTitle>

        <ConfigProvider
          theme={{
            components: {
              Input: {
                colorPrimary: "#E9B25F",
                activeBorderColor: "#E9B25F",
                hoverBorderColor: "#E9B25F",
              },
              TextArea: {
                colorPrimary: "#E9B25F",
                activeBorderColor: "#E9B25F",
                hoverBorderColor: "#E9B25F",
              },
              Upload: {
                colorPrimary: "#E9B25F",
                activeBorderColor: "#E9B25F",
                hoverBorderColor: "#E9B25F",
              },
              Rate: {
                colorPrimary: "#E9B25F",
                activeBorderColor: "#E9B25F",
                hoverBorderColor: "#E9B25F",
              },
              Button: {
                colorPrimary: "#E9B25F",
                colorPrimaryActive: "#CB8C2E",
                colorPrimaryBorder: "#E9B25F",
                colorPrimaryHover: "#DF9E3C",
              },
            },
          }}
        >
          <Form
            labelCol={{
              span: 4,
            }}
            wrapperCol={{
              span: 14,
            }}
            layout="horizontal"
            style={{
              maxWidth: 600,
            }}
            onFinish={handleSubmit}
            onFinishFailed={onFinishFailed}
          >
            <div className="productInfo">
              <div>
                <img
                  src={
                    productData.repPic === ""
                      ? process.env.PUBLIC_URL +
                        "/assets/images/defaultitemimg.svg"
                      : `${API_SERVER_HOST}/pic/product/${productData.iproduct}/${productData.repPic}`
                  }
                />
              </div>
              <div className="productInfoText">
                <p>{productData.productNm}</p>
              </div>
            </div>

            <RateAddBox>
              <div>
                <p>상품은 어떠셨나요 ?</p>
              </div>
              <Form.Item
                value={formData.name}
                style={{
                  width: "350px",
                  margin: "0px",
                  display: "flex",
                  justifyContent: "flex-end",
                  alignItems: "center",
                }}
                name="start"
              >
                <Rate
                  style={{
                    width: "200px",
                    fontSize: "40px",
                    display: "flex",
                    justifyContent: "flex-end",
                    alignItems: "center",
                  }}
                  value={formData.productScore}
                  onChange={value => handleScoreChange("productScore", value)}
                />
              </Form.Item>
            </RateAddBox>

            <Form.Item style={{ width: "1150px" }} name="contents">
              <TextArea
                // value={formData.contents}
                style={{
                  width: "1150px",
                  height: "600px",
                  padding: "40px",
                  fontSize: "20px",
                  boxShadow: "none",
                }}
                rows={4}
                showCount={true}
                maxLength={250}
                placeholder="직접 사용해 보시고 느끼신 점을 작성해 주세요!"
                autoSize={{
                  minRows: 17,
                  maxRows: 17,
                }}
                spellCheck={false}
                onChange={e => handleContentsChange("contents", e.target.value)}
              />
            </Form.Item>

            <div className="antdUploadDiv">
              <Form.Item
                style={{
                  width: "1150px",
                  height: "200px",
                }}
                valuePropName="fileList"
                getValueFromEvent={normFile}
              >
                <div
                  style={{
                    width: "1150px",
                    display: "flex",
                    justifyContent: "space-between",
                  }}
                >
                  <div
                    style={{
                      display: "flex",
                      justifyContent: "center",
                      alignItems: "center",
                    }}
                  >
                    <Upload
                      action="https://run.mocky.io/v3/435e224c-44fb-4773-9faf-380c5e6a2188"
                      listType="picture-card"
                      fileList={fileList}
                      onPreview={handlePreview}
                      onChange={handleChange}
                      maxCount={5}
                      multiple
                      accept="image/png,image/jpeg,image/jpg,"
                    >
                      {fileList.length >= 5 ? null : uploadButton}
                    </Upload>
                    <Modal
                      open={previewOpen}
                      title={previewTitle}
                      footer={null}
                      onCancel={handleCancel}
                    >
                      <img
                        alt="example"
                        style={{
                          width: "100%",
                        }}
                        src={previewImage}
                      />
                    </Modal>
                    <div>
                      <i>최대 5장까지 업로드 가능합니다.</i>
                    </div>
                  </div>

                  <div className="buttonDiv">
                    <Form.Item>
                      <Button
                        type="primary"
                        style={{
                          borderRadius: 0,
                          width: "140px",
                          height: "60px",
                        }}
                        htmlType="submit"
                      >
                        작성완료
                      </Button>
                    </Form.Item>
                    <Button
                      type="default"
                      style={{
                        borderRadius: 0,
                        width: "140px",
                        height: "60px",
                      }}
                    >
                      뒤로가기
                    </Button>
                  </div>
                </div>
              </Form.Item>
            </div>
          </Form>
        </ConfigProvider>
      </div>
    </ReviewAddWrap>
  );
};

export default ReviewAddPageCom;
