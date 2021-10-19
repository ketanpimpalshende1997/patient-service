package com.ct.patient.utility;

import lombok.Getter;

@Getter
public enum StatusMessage {
	USER_DETAILS_SAVED("User is saved"), USER_DETAILS_UPDATE("User is updated"),
	USER_DETAILS_UPDATED("User is updated"), SERVER_ERROR("Error while processing request");

	private String message;

	private StatusMessage(String message) {
		this.message = message;
	}

}
