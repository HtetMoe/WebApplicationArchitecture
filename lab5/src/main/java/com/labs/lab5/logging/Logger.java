package com.labs.lab5.logging;

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
@Table(name = "logs")
public class Logger {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long transactionID;
    private LocalDateTime dateTime;
    private Long executionTime;
    private String principle = "staticUser"; //fake static user
    private String operation;
}
