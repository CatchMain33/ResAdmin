package com.catchmind.resadmin.model.entity;

import com.catchmind.resadmin.model.config.Auditable2;
import com.catchmind.resadmin.model.config.BaseEntity2;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@NoArgsConstructor      //매개변수 없는 생성자(AdminUser())
@Data
@Builder
@ToString(callSuper = true)     //
@EqualsAndHashCode(callSuper = true)    //
@EntityListeners(AuditingEntityListener.class)
public class BisNotice extends BaseEntity2 implements Auditable2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long binIdx;
    private String binTitle;
    private String resaBisName;
    private String binContent;

    @Builder
    public BisNotice(Long binIdx, String binTitle, String resaBisName, String binContent) {
        this.binIdx = binIdx;
        this.binTitle = binTitle;
        this.resaBisName = resaBisName;
        this.binContent = binContent;
    }


}
