
package com.publicis.assignment.dto.ResponseDto;

public interface ErrorCodeEnum {
	
	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	String getErrorCode();
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    String getName();
    
    /**
     * Gets the service id.
     *
     * @return the service id
     */
    int getServiceId();
    
    /**
     * Gets the message key.
     *
     * @return the message key
     */
    String getMessageKey();
    
    /**
     * Gets the default message.
     *
     * @return the default message
     */
    String getDefaultMessage();
    
    /**
     * Gets the name of the error code as identified by the enum name
     * @return
     */
    String getEnumName();
}
