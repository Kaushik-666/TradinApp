package com.kaushik.exception;

public class TradeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1076305405451639188L;
	private String message;
	public TradeException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "TradeException [message=" + message + "]";
	}

}
