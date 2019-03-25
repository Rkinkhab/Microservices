package com.example.drug.drugservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Couldn't find any drugs for this expiration date")
public class DrugDataNotFoundException extends RuntimeException{

}
