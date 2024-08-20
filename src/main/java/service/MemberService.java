package service;

import dto.MemberSaveRequestDto;
import dto.MemberSaveResponseDto;
import entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.MemberRepository;

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

}
