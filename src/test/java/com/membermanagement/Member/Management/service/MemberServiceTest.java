package com.membermanagement.Member.Management.service;

import com.membermanagement.Member.Management.dto.CreateMemberRequest;
import com.membermanagement.Member.Management.dto.CreateMemberResponse;
import com.membermanagement.Member.Management.dto.UpdateMemberRequest;
import com.membermanagement.Member.Management.entity.People;
import com.membermanagement.Member.Management.exception.RecordNotFoundException;
import com.membermanagement.Member.Management.repository.MemberRepository;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository repo;

    @InjectMocks
    private MemberService service;

    @Spy
            private ModelMapper modelMapper;


    People member = new People("morales", "justin", "valencia", new Date(2022, 10, 3), true);
    CreateMemberRequest memberRequest1 = new CreateMemberRequest("mataac", "alex", "orante", new Date(2022, 10, 3), true);
    CreateMemberRequest memberRequest2 = new CreateMemberRequest("flores", "michael", "cezar", new Date(2022, 10, 3), true);
    UpdateMemberRequest memberRequest3 = new UpdateMemberRequest("regalado", "jerome", "garcia", new Date(2022, 10, 3), true);
    UpdateMemberRequest memberRequest4 = new UpdateMemberRequest("manghnani", "eshant", "p", new Date(2022, 10, 3), true);


    @Test
    @DisplayName("" +
            "Given Members with the setup above " +
            "When saveMember(CreateMemberRequest.class) is executed" +
            "Then result should return member")
    void saveMemberTest() {

        //Arrange
        CreateMemberRequest expectedMember = new CreateMemberRequest("morales", "justin", "valencia", new Date(2022, 10, 3), true);
        when(repo.save(any(People.class))).thenReturn(member);

        //Act
        CreateMemberResponse result = service.save(expectedMember);

        //Assert
        verify(repo).save(any(People.class));
        assertEquals(modelMapper.map(member, CreateMemberResponse.class), result);
    }
}

