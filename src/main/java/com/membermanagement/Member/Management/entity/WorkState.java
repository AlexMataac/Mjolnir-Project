package com.membermanagement.Member.Management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workstateid")
    private Integer workStateId;

    @Column(name = "workstatedesc", length = 100)
    private String workStateDesc;

    @Column(name = "isactive")
    private Boolean isActive;
}
