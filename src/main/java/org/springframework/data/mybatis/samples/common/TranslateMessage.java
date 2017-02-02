package org.springframework.data.mybatis.samples.common;

/**
 * Created by dka on 2/2/17.
 */
public class TranslateMessage {

	private String id;
	private String defaultMessage;

	public TranslateMessage(String id, String defaultMessage) {
		this.id = id;
		this.defaultMessage = defaultMessage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}
}
