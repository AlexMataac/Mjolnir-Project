package com.membermanagement.Member.Management.dto;

import com.membermanagement.Member.Management.entity.JobLevel;
import com.membermanagement.Member.Management.entity.WorkState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMemberRequest {

    @Size(min = 5, max = 50, message = "About Me must be between 10 and 200 characters")
    @NotNull
    private String lastName;

    @NotNull
    private String firstName;

    private String middleName;

    @NotNull
    private Date hiredDate;

    @NotNull
    private Boolean isActive;
}
