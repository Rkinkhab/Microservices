package com.example.prescribe.prescribeservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Couldn't find any prescriber for this expiration date")
public class PrescriberDataNotFoundException extends RuntimeException {

}
