package service;

import dto.MemberSaveRequestDto;
import dto.MemberSaveResponseDto;
import dto.MemberSimpleResponseDto;
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
}
