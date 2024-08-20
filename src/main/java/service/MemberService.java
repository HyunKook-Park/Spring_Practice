package service;

import dto.*;
import entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto) {
        Member member = new Member(requestDto.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers(){
        List<Member> memberList = memberRepository.findAll();
        List<MemberSimpleResponseDto> memberSimpleResponseDtoList = new ArrayList<>();
        for (Member member : memberList) {
            MemberSimpleResponseDto memberSimpleResponseDto = new MemberSimpleResponseDto(member.getName());
            memberSimpleResponseDtoList.add(memberSimpleResponseDto);
        }
        return memberSimpleResponseDtoList;
    }

    public MemberDetailResponseDto getMember(Long id){
        Member member = memberRepository.findById(id).orElseThrow(() -> new NullPointerException("member is not exists"));
        return new MemberDetailResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public MemberUpdateResponseDto updateMember(Long id, MemberUpdateRequestDto requestDto){
        Member member = memberRepository.findById(id).orElseThrow(() -> new NullPointerException("member is not exists"));
        member.update(requestDto.getName());
        return new MemberUpdateResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public void deleteMember(Long id){
        Member member = memberRepository.findById(id).orElseThrow(() -> new NullPointerException("member is not exists"));
        memberRepository.delete(member);
    }
}
