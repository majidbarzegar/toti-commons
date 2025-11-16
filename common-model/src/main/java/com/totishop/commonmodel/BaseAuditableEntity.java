package com.totishop.commonmodel;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */

@MappedSuperclass
@Getter
@Setter
public abstract class BaseAuditableEntity<ID extends Serializable> extends BaseEntity<ID> {
    @NonNull
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
