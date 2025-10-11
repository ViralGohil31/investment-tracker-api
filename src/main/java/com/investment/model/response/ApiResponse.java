package com.investment.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.investment.constant.ErrorCode;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private Instant timestamp;
    private int status;
    private T data;
    private List<ApiError> errors;

    @Builder
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class ApiError {
        @NonNull private ErrorCode code;
        @NonNull  private String message;
        private String field;

        public static ApiError of(ErrorCode code, String message) {
            return ApiError.builder()
                    .code(code)
                    .message(message)
                    .build();
        }
    }
}
