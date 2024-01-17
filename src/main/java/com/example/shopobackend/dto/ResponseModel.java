package com.example.shopobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseModel<T> {
    private int status;
    private String message;
    private String detailedMessage;
    private T data;
}
