package com.catchmind.resadmin.model.config;

import java.time.LocalDateTime;

public interface Auditable2 {
    LocalDateTime getRegDate();
    LocalDateTime getUpdateDate();

    void setRegDate(LocalDateTime regDate);
    void setUpdateDate(LocalDateTime updateDate);
}
