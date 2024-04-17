import DOMPurify from "dompurify";
import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useNavigate, useOutletContext, useParams } from "react-router";
import { useSearchParams } from "react-router-dom";
import { getOne } from "../../../api/community/communityApi";
import DefaultButton from "../../../components/basic/DefaultButton";
import useCustomMove from "../../../hooks/useCustomMove";
import { NoticeBoard } from "../styles/commStyle";
import Comment from "./Comment";

const initState = {
  iboard: 0,
  iuser: 0,
  title: "string",
  nm: "string",
  contents: "string",
  createdAt: "string",
};

const CommuRead = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [post, setPost] = useState(initState);
  const [urlSearchParams] = useSearchParams();
  const board = urlSearchParams.get("board_code");
  const { setMaintxt, setSubtxt } = useOutletContext();
  const { moveToModifyPage } = useCustomMove();
  const youNm = useSelector(state => state.loginSlice.nm);

  useEffect(() => {
    getOne(id)
      .then(result => {
        setPost(result);
      })
      .catch(error => {
        console.log(error);
      });
    if (board === "1") {
      setMaintxt("공지사항");
      setSubtxt("배송 및 상품관련 공지사항을 확인해 주세요.");
    } else if (board === "2") {
      setMaintxt("소통해요");
      setSubtxt("소통과 관련된 내용을 확인해 주세요.");
    } else if (board === "3") {
      setMaintxt("1:1 문의");
      setSubtxt("문의사항이 있으면 언제든지 문의해 주세요.");
    }
  }, [id]);

  const handleGoBack = () => {
    navigate(-1);
  };

  return (
    <>
      <NoticeBoard>
        <div className="wrap">
          <div className="aaa">
            <span>제목</span>
            <input type="text" value={post.title} readOnly />
          </div>
          <div className="bbb">
            <span>작성자</span>
            <input type="text" value={post.nm} readOnly />
          </div>
        </div>
        <div
          className="content-container"
          style={{
            minHeight: 500,
            overflow: "hidden",
          }}
          dangerouslySetInnerHTML={{
            __html: DOMPurify.sanitize(post.contents),
          }}
        ></div>
        <div className="wrap-footer">
          <p>{post.createdAt}</p>
          <div className="bts">
            <DefaultButton
              aa={handleGoBack}
              type="button"
              txt="뒤로가기"
              txtColor="#868686"
              borderColor="#868686"
            />
            {youNm === post.nm && (
              <DefaultButton
                aa={() => moveToModifyPage(post)}
                type="button"
                txt="수정하기"
                txtColor="#42B0FF"
                borderColor="#42B0FF"
              />
            )}
          </div>
        </div>
        {board === "1" ? null : <Comment id={id} />}
      </NoticeBoard>
    </>
  );
};

export default CommuRead;
