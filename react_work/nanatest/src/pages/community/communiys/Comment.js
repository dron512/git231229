import React, { useEffect, useState } from "react";

import DefaultButton from "../../../components/basic/DefaultButton";
import {
  deleteCommet,
  getList,
  patchCommet,
  postCommet,
} from "../../../api/community/commentApi";
import { CommentRead } from "../styles/commStyle";
import { useSelector } from "react-redux";

const initState = {
  icomment: 0,
  iuser: 0,
  nm: "",
  comment: "",
  createdAt: "",
};

const Comment = ({ id }) => {
  const [comment, setComment] = useState([initState]);
  const [openDropdown, setOpenDropdown] = useState(null);
  const [openPatch, setOpenPatch] = useState(null);
  const [commentPost, setCommentPost] = useState("");
  const [commentPatch, setCommentPatch] = useState("");
  const youNm = useSelector(state => state.loginSlice.nm);

  useEffect(() => {
    getList(id)
      .then(result => {
        setComment(result);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const handleModify = icomment => {
    setOpenPatch(icomment);
    setOpenDropdown(null);
  };

  const handleDelete = icomment => {
    deleteCommet(icomment).then(() => {
      getList(id).then(res => {
        setComment(res);
        setCommentPost("");
        setOpenPatch(null);
      });
    });

    setOpenDropdown(null);
  };

  const handleChangeC = e => {
    setCommentPost(e.target.value);
  };

  const handleChangeM = e => {
    setCommentPatch(e.target.value);
  };

  const handlePost = () => {
    if (commentPost.length > 1) {
      postCommet(id, commentPost).then(() => {
        getList(id).then(res => {
          setComment(res);
          setCommentPost("");
          setOpenPatch(null);
          setOpenDropdown(null);
        });
      });
    }
  };

  const handlePatch = icomment => {
    patchCommet(icomment, commentPatch).then(() => {
      getList(id).then(res => {
        setComment(res);
        setCommentPost("");
        setOpenPatch(null);
        setOpenDropdown(null);
      });
    });
  };

  return (
    <>
      <div
        style={{
          width: "100%",
          height: 57,
          display: "flex",
          marginBottom: 30,
          gap: 15,
        }}
      >
        <input
          style={{
            fontSize: "2rem",
            border: "1px solid #000",
          }}
          type="text"
          value={commentPost}
          onChange={handleChangeC}
          minLength={1}
          maxLength={40}
        />
        <DefaultButton
          aa={handlePost}
          type="button"
          txt="등록하기"
          txtColor="#42B0FF"
          borderColor="#42B0FF"
        />
      </div>
      <CommentRead>
        {comment.map(item => (
          <div key={item.icomment}>
            <div className="comment-top">
              <h3>{item.nm}</h3>
              {youNm === item.nm && (
                <button
                  style={{ width: 100, fontSize: "2rem", textAlign: "end" }}
                  type="button"
                  onClick={() =>
                    setOpenDropdown(
                      openDropdown === item.icomment ? null : item.icomment,
                    )
                  }
                >
                  ...
                </button>
              )}
              {openDropdown === item.icomment && (
                <div className="comment-bts">
                  <ul>
                    <li onClick={() => handleModify(item.icomment)}>
                      수정하기
                    </li>
                    <li onClick={() => handleDelete(item.icomment)}>
                      삭제하기
                    </li>
                    <li onClick={() => setOpenDropdown(null)}>취소하기</li>
                  </ul>
                </div>
              )}
            </div>
            {openPatch === item.icomment ? (
              <div
                style={{
                  width: "100%",
                  height: 30,
                  display: "flex",
                  marginBottom: 30,
                  gap: 15,
                }}
              >
                <input
                  style={{
                    fontSize: "2rem",
                    border: "1px solid #000",
                  }}
                  type="text"
                  defaultValue={item.comment}
                  onChange={e => {
                    handleChangeM(e);
                  }}
                  minLength={1}
                  maxLength={40}
                />
                <button
                  type="button"
                  style={{
                    background: "#fff",
                    border: "1px solid #000",
                    width: 100,
                    cursor: "pointer",
                  }}
                  onClick={() => handlePatch(item.icomment)}
                >
                  수정하기
                </button>
              </div>
            ) : (
              <div className="comment-mid">{item.comment}</div>
            )}
            <div className="comment-bottom">{item.createdAt}</div>
          </div>
        ))}
      </CommentRead>
    </>
  );
};

export default Comment;
