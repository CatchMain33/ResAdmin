package com.catchmind.resadmin.model.config;

import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getRegDate();


    void setRegDate(LocalDateTime regDate);

}
