package edu.miu.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Exception {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaction_id;
    @CreationTimestamp
    private LocalDate date;
    @CreationTimestamp
    private LocalTime time;

    private String principle;
    private String operation;
    private String message;
    private String exception_type;
}
