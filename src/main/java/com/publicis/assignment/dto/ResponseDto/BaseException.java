
package com.publicis.assignment.dto.ResponseDto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class BaseException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -896190511341174L;
    
    /** The message. */
    protected String message;
    
    /** The error code. */
    protected ErrorCodeEnum errorCode;
    
	/** The is severe. */
	protected boolean isSevere = false; 
    
    /** The debug message. */
    protected String debugMessage;
    
    /** The message args. */
    protected Map<String, String> messageArgs = new LinkedHashMap<String, String>();
    
    /**
     * Instantiates a new base exception.
     */
    public BaseException()
    {
    	super();
    }
    
    public BaseException(String msg)
    {
    	super(msg);
    }
    /**
     * Instantiates a new base exception.
     *
     * @param originalException the original exception
     */
    public BaseException(Throwable originalException)
    {
    	super(originalException);
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage(){
            return this.message;
    }
    
    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message){
            this.message = message;
    }
    
    /**
     * Gets the error code.
     *
     * @return the error code
     */
    public ErrorCodeEnum getErrorCode() {
            return errorCode;
    }
    
    /**
     * Sets the error code.
     *
     * @param errorCode the new error code
     */
    public void setErrorCode(ErrorCodeEnum errorCode) {
            this.errorCode = errorCode;
    }

    /**
     * Gets the debug message.
     *
     * @return the debug message
     */
    public String getDebugMessage() {
            return debugMessage;
    }
    
    /**
     * Sets the debug message.
     *
     * @param debugMessage the new debug message
     */
    public void setDebugMessage(String debugMessage) {
            this.debugMessage = debugMessage;
    }
    
    /**
     * Gets the message args.
     *
     * @return the message args
     */
    public Map<String, String> getMessageArgs() {
            return messageArgs;
    }
    
    /**
     * Sets the message args.
     *
     * @param messageArgs the message args
     */
    public void setMessageArgs(Map<String, String> messageArgs) {
            this.messageArgs = messageArgs;
    }

	
	/**
	 * Checks if is severe.
	 *
	 * @return true, if is severe
	 */
	public boolean isSevere() {
		return isSevere;
	}
	
	/**
	 * Sets the severe.
	 *
	 * @param isSevere the new severe
	 */
	public void setSevere(boolean isSevere) {
		this.isSevere = isSevere;
	}
	
	
	
   

}
