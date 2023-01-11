package com.membermanagement.Member.Management.controller;


import com.membermanagement.Member.Management.dto.CreateMemberRequest;
import com.membermanagement.Member.Management.dto.CreateMemberResponse;
import com.membermanagement.Member.Management.dto.UpdateMemberRequest;
import com.membermanagement.Member.Management.dto.UpdateMemberResponse;
import com.membermanagement.Member.Management.entity.People;
import com.membermanagement.Member.Management.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("")
    public ResponseEntity<CreateMemberResponse> addMember(@RequestBody @Valid CreateMemberRequest member) {
        return new ResponseEntity<>(memberService.save(member), HttpStatus.CREATED);
    }

    @PatchMapping("/{peopleId}")
    public ResponseEntity<UpdateMemberResponse> updateMember(@PathVariable Integer peopleId, @RequestBody UpdateMemberRequest member) {
        return new ResponseEntity<>(memberService.update(peopleId, member), HttpStatus.OK);
    }

//    @GetMapping("/{peopleId}")
//    public ResponseEntity<People> getMember(@PathVariable Integer peopleId) {
//        return new ResponseEntity<>(memberService.find(peopleId), HttpStatus.OK);
//    }
}
