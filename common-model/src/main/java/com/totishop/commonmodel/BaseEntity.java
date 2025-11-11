package com.totishop.commonmodel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity<ID extends Serializable> implements Persistable<ID> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    protected ID id;

    @Transient
    private boolean isNew = true;

    @Override
    public boolean isNew() {
        return this.isNew || id == null;
    }

    @PostLoad
    @PostPersist
    void markNotNew() {
        this.isNew = false;
    }
}