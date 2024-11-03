package com.labs.lab4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Logger {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long transaction_id;
    LocalDateTime dateTime;
    String principle;
    String operation;
}
