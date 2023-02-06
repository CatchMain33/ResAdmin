package com.catchmind.resadmin.model.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@NoArgsConstructor      //매개변수 없는 생성자(AdminUser())
@AllArgsConstructor     //매개변수 다 있는 생성자 (그위에 (Long, String,....))
@Data
@Builder
@ToString(callSuper = true)     // //
@EntityListeners(AuditingEntityListener.class)
public class totalTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long totTableId;
    private String resaBisName;
    private String totCapacity;
    private String totTable;
}
