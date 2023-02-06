package com.catchmind.resadmin.model.entity;

import com.catchmind.resadmin.model.config.Auditable;
import com.catchmind.resadmin.model.config.BaseEntity;
import com.catchmind.resadmin.model.config.Auditable;
import com.catchmind.resadmin.model.config.BaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Entity
@NoArgsConstructor      //매개변수 없는 생성자(AdminUser())
@AllArgsConstructor     //매개변수 다 있는 생성자 (그위에 (Long, String,....))
@Data
@Builder
@ToString(callSuper = true)     //
@EqualsAndHashCode(callSuper = true)    //
@EntityListeners(AuditingEntityListener.class)
public class ResAdmin extends BaseEntity implements Auditable {

    private String resaUserid;
    private String resaUserpw;
    private String resaName;
    private String resaHp;
    private String resaRegion;
    @Id
    private String resaBisName;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resa_bis_name")
//    private List<Menu> menus;
}
