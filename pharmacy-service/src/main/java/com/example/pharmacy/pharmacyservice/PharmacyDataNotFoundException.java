package com.example.pharmacy.pharmacyservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Couldn't find any pharmacies for this expiration date")
public class PharmacyDataNotFoundException extends RuntimeException{

}
