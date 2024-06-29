package com.publicis.assignment.dto.ResponseDto;


import lombok.Data;

@Data
public class ServiceResponse<T> {

	private T data;
	private int status;




}
