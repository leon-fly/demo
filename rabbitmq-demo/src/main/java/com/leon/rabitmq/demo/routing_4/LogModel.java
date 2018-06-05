package com.leon.rabitmq.demo.routing_4;

public class LogModel {
	public static String LOG_LEVEL_INFO = "info";
	public static String LOG_LEVEL_WARNING = "warning";
	public static String LOG_LEVEL_ERROR = "error";
	public static String LOG_TYPE_TRADE = "trade";
	public static String LOG_TYPE_SERVICE = "service";
	public static String LOG_TYPE_FUNC = "func";
	
	private String logLevel;
	private String message;
	private String logType;

	public LogModel() {
		super();
	}

	public LogModel(String logLevel, String message) {
		super();
		this.logLevel = logLevel;
		this.message = message;
	}
	

	public LogModel(String logLevel, String message, String logType) {
		super();
		this.logLevel = logLevel;
		this.message = message;
		this.logType = logType;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	
}
