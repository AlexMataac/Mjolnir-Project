package com.membermanagement.Member.Management.dto;


import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class CreateMemberResponse {

    private Integer peopleId;

    private String lastName;

    private String firstName;

    private String middleName;

    private LocalDate hiredDate;

    private Boolean isActive;
}
