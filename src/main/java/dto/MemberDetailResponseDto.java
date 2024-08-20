package dto;

import lombok.Getter;

@Getter
public class MemberDetailResponseDto {
    private Long id;
    private String name;

    public MemberDetailResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
