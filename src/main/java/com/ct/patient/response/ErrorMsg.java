package com.ct.patient.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorMsg {
	public static class InternalServerError {

		@Schema(example = "500")
		public String responseCode;
		@Schema(example = "Internal Server Error")
		public String responseMsg;
		@Schema(example = "2021-09-02T17:28:28+05:30")
		public String timeStamp;

	}
	
	public static class BadRequest {

		@Schema(example = "400")
		public String responseCode;
		@Schema(example = "Bad Request")
		public String responseMsg;
		@Schema(example = "2021-09-02T17:28:28+05:30")
		public String timeStamp;

	}

}
