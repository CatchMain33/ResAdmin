package com.catchmind.resadmin.model.config;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity2 {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime regDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    private LocalDateTime updateDate;
}
