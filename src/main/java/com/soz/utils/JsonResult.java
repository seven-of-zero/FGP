package com.soz.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class JsonResult implements Serializable {
    private static final long serialVersionUID = -856924038217431339L;
    private int state = 1;
    private String message="ok";
    private Object data;
    public JsonResult() {
        // TODO Auto-generated constructor stub
    }
    public JsonResult(String message) {
        this.message=message;
    }
    public JsonResult(Object data) {
        this.data=data;
    }
    public JsonResult(Throwable t) {
        this.state=0;
        this.message=t.getMessage();
    }

}
