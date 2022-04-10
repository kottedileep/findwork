package com.fwork.model;

import java.time.LocalDateTime;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
public class ApiErrors {
	private LocalDateTime localDateTime;
	private String message;
	private HttpStatus status;


	public ApiErrors(LocalDateTime localDateTime, String message, HttpStatus status) {
		this.localDateTime = localDateTime;
		this.message = message;
		this.status = status;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "ApiErrors{" +
				"localDateTime=" + localDateTime +
				", message='" + message + '\'' +
				", status=" + status +
				'}';
	}
}
