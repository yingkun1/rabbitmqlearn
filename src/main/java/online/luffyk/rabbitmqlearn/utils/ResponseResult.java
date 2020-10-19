package online.luffyk.rabbitmqlearn.utils;

public class ResponseResult {
    private String msg;     //返回的提示消息
    private Object data;    //返回的data数据
    private Integer code;   //返回的状态码0成功，非0失败

    public ResponseResult() {
    }

    public ResponseResult(String msg, Object data, Integer code) {
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                ", code=" + code +
                '}';
    }
}
