package com.example.member.memberservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Couldn't find any members for this expiration date")
public class MemberDataNotFoundException extends RuntimeException {

	public MemberDataNotFoundException() {
		super();
	}

	public MemberDataNotFoundException(String Exception) {
		super(Exception);
	}
}
