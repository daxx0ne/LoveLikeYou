package com.ll.gramgram.boundedContext.likeablePerson.entity;

import com.ll.gramgram.boundedContext.instaMember.entity.InstaMember;
import com.ll.gramgram.base.baseEntity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class LikeablePerson extends BaseEntity {

    @ManyToOne
    @ToString.Exclude
    private InstaMember fromInstaMember; // 호감을 표시한 사람(인스타 멤버)
    private String fromInstaMemberUsername; // 혹시 몰라서 기록

    @ManyToOne
    @ToString.Exclude
    private InstaMember toInstaMember; // 호감을 받은 사람(인스타 멤버)
    private String toInstaMemberUsername; // 혹시 몰라서 기록

    @Setter
    private int attractiveTypeCode; // 매력포인트(1=외모, 2=성격, 3=능력)

    public String getAttractiveTypeDisplayName() {
        return switch (attractiveTypeCode) {
            case 1 -> "외모";
            case 2 -> "성격";
            default -> "능력";
        };
    }


    public void setAttractiveTypeCode(int attractiveTypeCode) {
        this.attractiveTypeCode = attractiveTypeCode;
    }
}
