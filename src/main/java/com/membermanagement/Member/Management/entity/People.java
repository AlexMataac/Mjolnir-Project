package com.membermanagement.Member.Management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peopleid")
    private Integer peopleId;

    @Column(name = "cognizantid")
    private Integer cognizantId;

    @Column(name = "lastname", length = 50)
    private String lastName;

    @Column(name = "firstname", length = 40)
    private String firstName;

    @Column(name = "middlename", length = 40)
    private String middleName;

    @Column(name = "fullname", length = 130)
    private String fullName;

    @Column(name = "csvemail", length = 50)
    private String csvEmail;

    @Column(name = "hireddate")
    private Date hiredDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "communityid", insertable = false, updatable = false)
    private Community communityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "communityadminandmanagerid", insertable = false, updatable = false)
    private CommunityAdminAndManager communityAdminAndManagerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "joblevelid", insertable = false, updatable = false)
    private JobLevel jobLeveLId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectid", insertable = false, updatable = false)
    private Project projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workstateid", insertable = false, updatable = false)
    private WorkState workStateId;

    @Column(name = "isprobationary")
    private Boolean isProbationary = false;

    @Column(name = "isactive")
    private Boolean isActive;

    public People(String lastName, String firstName, String middleName, Date hiredDate, Boolean isActive) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.hiredDate = hiredDate;
        this.isActive = isActive;
    }
}
