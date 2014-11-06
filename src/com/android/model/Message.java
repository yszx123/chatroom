package com.android.model;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3465930416189461897L;

	public static final int TYPE_RECEIVED = 0;

	public static final int TYPE_SENT = 1;

	private String content;

	private int type;

	public Message(String content, int type) {
		this.content = content;
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public int getType() {
		return type;
	}

}
