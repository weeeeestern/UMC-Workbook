package umc.spring.study.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.code.status.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ResponseDto<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;

    private final String code;

    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    public static <T> ResponseDto<T> onSuccess(T result, SuccessStatus status) {
        return new ResponseDto<>(true, status.getCode(), status.getMessage(), result);
    }

    public static <T> ResponseDto<T> onFailure(ErrorStatus status) {
        return new ResponseDto<>(false, status.getCode(), status.getMessage(), null);
    }
}

