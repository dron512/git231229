package com.mh.green2nd.pay;

import com.mh.green2nd.pay.response.CommonResult;
import com.mh.green2nd.pay.response.SingleResult;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public enum CommonResponse {
        Success(0, "success"),
        Fail(1, "fail");
        int code;
        String msg;
        CommonResponse(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }


    public <T>SingleResult<T> getSingleResult(T data){
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    private void setSuccessResult(CommonResult result){
        result.setSuccess(true);
        result.setCode(CommonResponse.Success.getCode());
        result.setMsg(CommonResponse.Success.getMsg());

    }

}
