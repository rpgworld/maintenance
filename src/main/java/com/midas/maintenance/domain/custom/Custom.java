package com.midas.maintenance.domain.custom;

import com.midas.maintenance.domain.Address;

import javax.persistence.*;

@Entity
public class Custom {

    @Id @GeneratedValue
    @Column(name = "custom_id")
    private Long id;

    private String name;
    private String tel;
    private String email;

    // 대표자 정보
    private String representative;
    private String representativeTel;

    @Embedded
    Address address;
}
