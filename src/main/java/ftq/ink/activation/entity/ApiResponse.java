package ftq.ink.activation.entity;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    // 响应状态码
    private int code;

    // 响应信息
    private String message;

    // 响应数据
    private T data;

    // 构造方法
    public ApiResponse() {}

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 静态方法，简化对象创建
    public static <T> ApiResponse<T> success(String message) {
        return success(message, null);
    }

    // 静态方法，简化对象创建
    public static <T> ApiResponse<T> success(T data) {
        return success("success", data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(HttpStatus.OK.value(), message, data);
    }

    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(500, message, null);
    }

    // Getter 和 Setter
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
               "code=" + code +
               ", message='" + message + '\'' +
               ", data=" + data +
               '}';
    }
}
