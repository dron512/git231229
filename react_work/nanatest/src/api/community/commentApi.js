import jwtAxios from "../../util/jwtUtil";

export const getList = async id => {
  try {
    const res = await jwtAxios.get(`/api/comment?iboard=${id}`);

    // HTTP 상태 코드 파악하기
    const status = res.status.toString();
    // 문자열 예) "200" 또는 "404" 의 0번 위치 글자를 알아낸다.
    const httpSt = status.charAt(0);
    if (httpSt === "2") {
      return res.data;
    } else {
      return "잘못된 정보를 전달함.";
    }
  } catch (error) {
    console.log(error);
  }
};

export const postCommet = async (iboard, comment) => {
  try {
    const commentPost = { iboard, comment };
    const res = await jwtAxios.post(
      `/api/comment?iboard=${iboard}&comment=${comment}`,
      commentPost,
    );

    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      return res.data.result;
    }
  } catch (error) {
    // console.log("서버에러에요");
  }
};

export const deleteCommet = async icomment => {
  try {
    const res = await jwtAxios.delete(`/api/comment?icomment=${icomment}`);
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      return res.data.result;
    }
  } catch (error) {
    // console.log("서버에러에요");
  }
};

export const patchCommet = async (icomment, comment) => {
  try {
    const commentPatch = { icomment, comment };
    const res = await jwtAxios.patch(
      `/api/comment?icomment=${icomment}&comment=${comment}`,
      commentPatch,
    );
    const status = res.status.toString();
    if (status.charAt(0) === "2") {
      return res.data.result;
    }
  } catch (error) {
    // console.log("서버에러에요");
  }
};
