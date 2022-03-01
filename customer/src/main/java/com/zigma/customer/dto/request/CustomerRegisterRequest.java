package com.zigma.customer.dto.request;

public record CustomerRegisterRequest(
    String firstName,
    String lastName,
    String email) {

}
