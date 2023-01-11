package com.membermanagement.Member.Management.dto;

import com.membermanagement.Member.Management.entity.JobLevel;
import com.membermanagement.Member.Management.entity.WorkState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberRequest {

    private String lastName;

    private String firstName;

    private String middleName;

    private Date hiredDate;

    private Boolean isActive;
}
