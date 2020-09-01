package com.xinwen.openapi.gateway.dto;

import java.io.Serializable;

public abstract class Reponse implements Serializable {

    public int resCode;
    public String message;

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
