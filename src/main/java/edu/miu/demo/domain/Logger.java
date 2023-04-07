package edu.miu.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaction_id;
    @CreationTimestamp
    private LocalDate date;
    @CreationTimestamp
    private LocalTime time;

    private String principle;
    private String operation;
}
