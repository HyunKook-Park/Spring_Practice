package controller;

import dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto requestDto){
        return ResponseEntity.ok(memberService.saveMember(requestDto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberSimpleResponseDto>> getAllMembers(){
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/members/{Id}")
    public ResponseEntity<MemberDetailResponseDto> getMember(@PathVariable Long Id){
        return ResponseEntity.ok(memberService.getMember(Id));
    }

    @PutMapping("/members/{Id}")
    public ResponseEntity<MemberUpdateResponseDto> updateMember(@PathVariable Long Id, @RequestBody MemberUpdateRequestDto requestDto){
        return ResponseEntity.ok(memberService.updateMember(Id, requestDto));
    }
    @DeleteMapping("/members/{Id}")
    public void deleteMember(@PathVariable Long Id){
        memberService.deleteMember(Id);
    }
}
