package com.catchmind.resadmin.model.entity;

import com.catchmind.resadmin.model.config.Auditable;
import com.catchmind.resadmin.model.config.BaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@NoArgsConstructor      //매개변수 없는 생성자(AdminUser())
@AllArgsConstructor     //매개변수 다 있는 생성자 (그위에 (Long, String,....))
@Data
@Builder
@ToString(callSuper = true)     //
@EntityListeners(AuditingEntityListener.class)
public class BistroDetail{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bdIdx;
    private String bdNotice;
    private String bdPark;
    private String bdAddr;
    private String bdHp;
    private String bdIntro;
    private String bdCaution;
    private String bdHour;
    private String bdHoliday;
    private String bdHomepage;
    private String resaBisName;
}
