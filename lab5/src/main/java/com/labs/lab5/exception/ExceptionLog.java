package com.labs.lab5.exception;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exceptions")
public class ExceptionLog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long transactionId;
    private LocalDateTime dateTime;
    private Long executionTime;
    private String principle;
    private String operation;
    private String exceptionType;
}
