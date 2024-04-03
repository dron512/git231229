package com.mh.restapi05.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDateTime;

    @LastModifiedDate
//    @Column(updatable = true) 기본값이 true
    private LocalDateTime updateDateTime;

//    @CreatedBy
//    @Column(updatable = false)
//    private String creator;
//
//    @LastModifiedBy
//    private String updator;

}
