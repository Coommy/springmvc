package com.commy.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import java.io.StringWriter;

/**
 * 基础Controller
 * Created by xuht on 2017/4/13.
 */
public class BaseController {
    private Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected static final String TYPE_JSON = MediaType.APPLICATION_JSON.toString() + ";charset=utf-8";
    protected static final String TEXT_PLAIN = MediaType.TEXT_PLAIN.toString() + ";charset=utf-8";

    public String buildMessage(int status){
        return buildMessage(status, null, null);
    }

    public String buildMessage(int status, Object data){
        return buildMessage(status, null, data);
    }

    public String buildMessage(int status, String msg, Object data){
        StringWriter writer = new StringWriter() ;
        try{
            ResultModal resultModal = new ResultModal(status ,msg ,data );
            ObjectMapper mapper = new ObjectMapper() ;
            mapper.writeValue(writer, resultModal);
            writer.flush();
            writer.close();
        }catch(Exception e){
            logger.error("web build message error", e);
        }
        return writer.toString() ;
    }

    public class ResultModal{
        public static final int SUCCESS = 200 ;
        public static final int FAIL = 500 ;
        public static final int DIALOG = 0 ;
        public static final int MESSAGE = 1 ;
        //private int msgType ;
        //private String state ;
        private int errCode ;
        private String message ;
        private Object data ;
        public ResultModal( int state , String msg , Object data){
            //this.state = state ;
            this.errCode = state ;
            this.message = msg ;
            this.data = data ;
            /*this.msgType = msgType ;*/
        }
        public ResultModal(){

        }

        public int getErrCode() {
            return errCode;
        }

        public void setErrCode(int errCode) {
            this.errCode = errCode;
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
}
