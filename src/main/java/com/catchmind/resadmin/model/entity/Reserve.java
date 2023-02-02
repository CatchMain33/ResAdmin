package com.catchmind.resadmin.model.entity;

import com.catchmind.resadmin.model.config.Auditable2;
import com.catchmind.resadmin.model.config.BaseEntity2;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@NoArgsConstructor      //매개변수 없는 생성자(AdminUser())
@AllArgsConstructor     //매개변수 다 있는 생성자 (그위에 (Long, String,....))
@Data
@Builder
@ToString(callSuper = true)     //
@EqualsAndHashCode(callSuper = true)    //
@EntityListeners(AuditingEntityListener.class)
public class Reserve extends BaseEntity2 implements Auditable2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resIdx;
    private String resaBisName;
    private int prIdx;
    private String resName;
    private String resHp;
    private String resRequest;
    private String visitName;
    private String visitHp;
    private String resMonth;
    private String resDay;
    private String resPerson;
    private String resTime;
    private String resStatus;
    private String resReason;

}
