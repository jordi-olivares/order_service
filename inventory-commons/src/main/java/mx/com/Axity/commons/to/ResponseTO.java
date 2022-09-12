package mx.com.Axity.commons.to;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class ResponseTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7449115534572237478L;
    private int code;

    private String message;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", this.code).append("message", this.message).toString();
    }

}

