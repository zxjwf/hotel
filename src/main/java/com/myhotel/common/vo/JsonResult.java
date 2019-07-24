package com.myhotel.common.vo;

import java.io.Serializable;

public class JsonResult implements Serializable {
    private static final long serialVersionUID=6205026608497559648L;
    private Integer state=1;
    private String message="ok";
    private Object data;

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(Throwable e){
        this.state=0;
        this.message=e.getMessage();
    }

    public JsonResult(Integer state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
