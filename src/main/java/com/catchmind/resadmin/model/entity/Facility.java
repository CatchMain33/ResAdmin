package com.catchmind.resadmin.model.entity;

import com.catchmind.resadmin.model.config.Auditable;
import com.catchmind.resadmin.model.config.Auditable2;
import com.catchmind.resadmin.model.config.BaseEntity;
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
public class Facility extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facIdx;
    private String resaBisName;
    private Long bisIdx;
    private boolean facParking;
    private boolean facValet;
    private boolean facCorkage;
    private boolean facNokid;
    private boolean facAnimal;
    private boolean facHandi;
}
