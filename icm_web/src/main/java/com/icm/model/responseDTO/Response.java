package com.icm.model.responseDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Response implements Serializable {

	
	private static final long serialVersionUID = 7996664536603472824L;

	public static final String TOTAL_SIZE = "tsize";
	public static final String GRID_DATA = "gridData";
	public static final Boolean SUCCESS = true;
	public static final Boolean FAILED = false;


	private boolean success = false;

	private Object data;

	private String reason = null;
	private int status;


	/**
	 * Success response
	 * 
	 * @param success
	 * @param data
	 */
	public Response(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}

	/**
	 * Failure response
	 * 
	 * @param data
	 * @param reason
	 */
	public Response(String data, String reason) {
		this.data = data;
		this.reason = reason;
	}

	/**
	 * Failure response with data
	 * 
	 * @param success
	 * @param data
	 * @param reason
	 */
	public Response(boolean success, Object data, String reason) {
		this.success = success;
		this.data = data;
		this.reason = reason;
	}
	
	public Response(boolean success, Object data, String reason,int status) {
		this.success = success;
		this.data = data;
		this.reason = reason;
		this.status=status;
	}


	public Response(int scExpectationFailed) {
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}





}
