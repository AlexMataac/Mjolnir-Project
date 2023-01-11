package com.membermanagement.Member.Management.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.membermanagement.Member.Management.dto.CreateMemberRequest;
import com.membermanagement.Member.Management.dto.CreateMemberResponse;
import com.membermanagement.Member.Management.dto.UpdateMemberRequest;
import com.membermanagement.Member.Management.dto.UpdateMemberResponse;
import com.membermanagement.Member.Management.entity.People;
import com.membermanagement.Member.Management.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.beans.FeatureDescriptor;
import java.lang.module.ResolutionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repo;

    @Autowired
    private ModelMapper modelMapper;


    @Transactional
    public CreateMemberResponse save(CreateMemberRequest memberRequest) {
        People people = repo.save(modelMapper.map(memberRequest, People.class));
        return modelMapper.map(people, CreateMemberResponse.class);
    }

    @Transactional
    public UpdateMemberResponse update(Integer peopleId, UpdateMemberRequest memberRequest) {
        People people = repo.retrieveMemberByPeopleId(peopleId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        BeanUtils.copyProperties(memberRequest, people, getNullPropertyNames(memberRequest));
        return modelMapper.map(repo.save(people), UpdateMemberResponse.class);
    }

//    public People find(Integer peopleId) {
//        return repo.retrievePeopleById(peopleId)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null || Objects.equals(wrappedSource.getPropertyValue(propertyName), ""))
                .toArray(String[]::new);
    }
}
