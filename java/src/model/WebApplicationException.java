package model;

public class WebApplicationException extends RuntimeException{

    private int code;

    public WebApplicationException(String cause, int code){
        super(cause);
        this.code = code;
    }

}
