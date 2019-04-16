package ru.xpendence.rebounder.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 14.04.19
 * Time: 21:20
 * e-mail: 2262288@gmail.com
 */
@Setter
@Entity
@Table(name = "request_logs")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Log implements Serializable {

    private Long id;
    private LocalDateTime created;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    public LocalDateTime getCreated() {
        return created;
    }

    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
    }
}
