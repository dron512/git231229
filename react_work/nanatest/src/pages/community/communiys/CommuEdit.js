import { motion } from "framer-motion";
import ImageResize from "quill-image-resize-module-react";
import React, { useEffect, useMemo, useRef, useState } from "react";
import { useForm } from "react-hook-form";
import { Quill } from "react-quill";
import * as yup from "yup";
import {
  useLocation,
  useNavigate,
  useOutletContext,
  useSearchParams,
} from "react-router-dom";
import {
  deleteBoard,
  getIBorad,
  postImage,
  putBoard,
} from "../../../api/community/communityApi";
import DefaultButton from "../../../components/basic/DefaultButton";
import ResultModal from "../../../components/signup/ResultModal";
import useCustomMove from "../../../hooks/useCustomMove";
import jwtAxios from "../../../util/jwtUtil";
import { Axx, Azxc, StyledReactQuill } from "../styles/commStyle";
import { yupResolver } from "@hookform/resolvers/yup";

Quill.register("modules/imageResize", ImageResize);

const CommuEdit = () => {
  const navigate = useNavigate();

  const [urlSearchParams] = useSearchParams();
  const board = urlSearchParams.get("board_code");
  const { setMaintxt, setSubtxt } = useOutletContext();
  const { moveToPrev, moveToListPahe } = useCustomMove();
  const [isOpen, setIsOpen] = useState(false);
  const [isOpenD, setIsOpenD] = useState(false);
  const [iBoard, setIBoard] = useState(0);
  const location = useLocation();
  const bordPut = location.state;

  useEffect(() => {
    setIBoard(bordPut.iboard);
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
  }, []);

  const quillRef = useRef(null);

  const [imgList, setImgList] = useState([]);

  useEffect(() => {}, [imgList]);

  const sendImageFn = _file => {
    const formData = new FormData();
    formData.append("pics", _file);
    postImage(iBoard, { pics: formData, successFn, failFn, errorFn });
  };
  const successFn = _result => {
    console.log("이미지 업로드 성공 : ", _result);
  };
  const failFn = _result => {
    console.log("실패 : ", _result);
  };

  const errorFn = _result => {
    console.log("서버에러 : ", _result);
  };

  const imageHandler = async () => {
    const input = document.createElement("input");
    input.setAttribute("type", "file");
    input.setAttribute("accept", "image/*");
    input.click();

    input.addEventListener("change", async () => {
      try {
        const newIBoard = await getIBorad();
        let imgUrl = "http://192.168.0.144:5223/pic";
        const serverImgUrl = "/pic";
        const file = input.files[0];
        const formData = new FormData();
        formData.append("pics", file);
        const header = { headers: { "Content-Type": "multipart/form-data" } };

        const res = await jwtAxios.post(
          `/api/board/image-upload?iboard=${newIBoard}`,
          formData,
          header,
        );
        const resStatus = res.status.toString();
        if (resStatus.charAt(0) === "2") {
          imgUrl = `${serverImgUrl}${res.data}`;
          setImgList(prevUrl => [...prevUrl, imgUrl]);
          const editor = quillRef.current.getEditor();
          const range = editor.getSelection();
          editor.insertEmbed(range.index, "image", imgUrl);
          editor.setSelection(range.index + 1);
        } else {
          console.log("업로드 실패입니다.");
        }
      } catch (error) {
        errorFn(error);
      }
    });
  };

  const modules = useMemo(
    () => ({
      toolbar: {
        container: [
          [{ header: [1, 2, 3, 4, 5, 6, false] }],
          [{ font: [] }],
          [{ align: [] }],
          ["bold", "italic", "underline", "strike", "blockquote"],
          [{ list: "ordered" }, { list: "bullet" }],
          [
            {
              color: [],
            },
            { background: [] },
          ],
          ["image"],
        ],
        handlers: { image: imageHandler },
      },
      imageResize: {
        parchment: Quill.import("parchment"),
        modules: ["Resize", "DisplaySize", "Toolbar"],
      },
    }),
    [],
  );

  const handleClika = () => {
    navigate(-1);
  };

  const handleDelete = iboard => {
    deleteBoard(iboard);
    setIsOpenD(true);
  };

  const validationSchema = yup.object({
    title: yup
      .string("제목을 입력하세요.")
      .required("제목은 필수입니다.")
      .min(4, "4자 이상 입력하세요.")
      .max(16, "16자까지만 입력하세요 "),
  });

  const { register, handleSubmit, setValue, formState } = useForm({
    defaultValues: bordPut,
    resolver: yupResolver(validationSchema),
  });

  const handleSubmitMy = data => {
    if (data.contents === "<p><br></p>" || data.contents === "") {
      alert("내용을 입력하세요.");
      return;
    }

    const formData = new FormData();
    // if (data.contents === <p></br></p> || "") {
    //   return alert("내용이 비어 있습니다");
    // }

    const dto = new Blob(
      [
        JSON.stringify({
          iboard: iBoard,
          boardCode: parseInt(board),
          title: data.title,
          contents: data.contents,
        }),
      ],

      { type: "application/json" },
    );
    formData.append("dto", dto);

    putBoard(formData);

    setIsOpen(true);
  };

  return (
    <>
      <motion.form
        initial={{ opacity: 0, y: 50 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 1 }}
        onSubmit={handleSubmit(handleSubmitMy)}
      >
        <div className="wrap">
          <Axx>
            <input
              type="text"
              defaultValue={bordPut.title}
              placeholder="제목을 입력해 주세요."
              {...register("title")}
            />
            <div style={{ color: "red" }}>
              {formState.errors.title?.message}
            </div>
            <hr />
            <div style={{ color: "red" }}>
              {formState.errors.contents?.message}
            </div>
            {/* StyledReactQuill */}
            <StyledReactQuill
              ref={quillRef}
              theme="snow"
              defaultValue={bordPut.contents}
              modules={modules}
              placeholder="여러분의 경험을 자유롭게 적어주세요."
              preserveWhitespace
              onChange={value => setValue("contents", value)}
            />
          </Axx>
          <Azxc>
            <div className="ps">
              <p>작성일</p>
              <p>{bordPut.createdAt}</p>
            </div>
            <div className="bts">
              <DefaultButton
                aa={handleClika}
                type="button"
                txt="뒤로가기"
                txtColor="#868686"
                borderColor="#868686"
              />
              <DefaultButton
                type="submit"
                txt="수정하기"
                txtColor="#42B0FF"
                borderColor="#42B0FF"
              />
              <DefaultButton
                aa={() => {
                  handleDelete(bordPut.iboard);
                }}
                type="button"
                txt="삭제하기"
                txtColor="#FF4E4E"
                borderColor="#FF4E4E"
              />
            </div>
          </Azxc>
        </div>
        {isOpen && (
          <ResultModal
            title={"수정 성공"}
            message={"게시물이 수정 되었습니다."}
            callFN={moveToPrev}
          />
        )}
        {isOpenD && (
          <ResultModal
            title={"삭제 성공"}
            message={"게시물이 삭제 되었습니다."}
            callFN={moveToListPahe}
          />
        )}
      </motion.form>
    </>
  );
};

export default CommuEdit;
