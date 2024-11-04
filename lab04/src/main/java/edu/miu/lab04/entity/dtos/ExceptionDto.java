package edu.miu.lab04.entity.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ExceptionDto {
    private Long transactionId;
    private LocalDate date;
    private LocalTime time;
    private String operation;
    private String exceptionType;
}
