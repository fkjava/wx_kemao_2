package org.fkjava.wexin.domain.text;

import org.fkjava.wexin.domain.OutMessage;

public class TextOutMessage extends OutMessage {

	private String text;

	public TextOutMessage(String toUser, String text) {
		super(toUser, "text");
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
