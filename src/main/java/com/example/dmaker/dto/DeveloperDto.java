package com.example.dmaker.dto;

import com.example.dmaker.entity.Developer;
import com.example.dmaker.type.DeveloperLevel;
import com.example.dmaker.type.DeveloperSkillLevel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DeveloperDto {
    private DeveloperLevel developerLevel;
    private DeveloperSkillLevel developerSkillLevel;
    private String memberId;

    public static DeveloperDto fromEntity(Developer developer) {
        return DeveloperDto.builder()
                .developerLevel(developer.getDeveloerLevel())
                .developerSkillLevel(developer.getDeveloerSkillLevel())
                .memberId(developer.getMemberId())
                .build();
    }
}
