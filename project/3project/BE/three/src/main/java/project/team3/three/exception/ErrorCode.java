package project.team3.three.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@ToString
public enum ErrorCode {
    DUPLICATE(HttpStatus.BAD_REQUEST,"DUPLICATION","중복된 내용이 있습니다."),
    NOTSELECT(HttpStatus.NOT_FOUND,"NOTFSELECT","조회할 내용이 없습니다."),
    NOTUPDATE(HttpStatus.NOT_FOUND, "NOTUPDATE", "수정할 내용이 없습니다."),
    NOTDELETE(HttpStatus.NOT_FOUND, "NOTDELETE", "삭제할 내용이 없습니다."),
    NOTINSERT(HttpStatus.NOT_FOUND, "NOTINSERT", "내용을 등록할 수 없습니다.");

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
