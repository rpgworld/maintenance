package com.midas.maintenance.domain.member;

import com.midas.maintenance.domain.Address;
import com.midas.maintenance.domain.custom.Custom;
import com.midas.maintenance.domain.maintenance.Maintenance;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String email;
    private String tel;
    
    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custom_id")
    private Custom custom;

    @OneToMany(mappedBy = "requestor")
    private List<Maintenance> requestors = new ArrayList<>();

    @OneToMany(mappedBy = "pic")
    private List<Maintenance> pics = new ArrayList<>();

    @Builder
    public Member(String name, String email, String tel, Custom custom) {
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.custom = custom;
    }
}
