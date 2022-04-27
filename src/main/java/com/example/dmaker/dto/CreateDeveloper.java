package com.example.dmaker.dto;

import com.example.dmaker.entity.Developer;
import com.example.dmaker.type.DeveloperLevel;
import com.example.dmaker.type.DeveloperSkillLevel;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateDeveloper {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        @NotNull
        private DeveloperLevel developerLevel;
        @NotNull
        private DeveloperSkillLevel developerSkillLevel;
        @NotNull
        @Min(0)
        @Max(20)
        private Integer experienceYears;

        @NotNull
        @Size(min = 3, max = 50, message = "memberId size must 3~50")
        private String memberId;
        @NotNull
        @Size(min = 3, max = 20, message = "memberId size must 3~20")
        private String name;
        @Min(18)
        private Integer age;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private DeveloperLevel developerLevel;
        private DeveloperSkillLevel developerSkillLevel;
        private Integer experienceYears;
        private String memberId;

        public static Response fromEntity(Developer developer){
            return Response.builder()
                    .developerLevel(developer.getDeveloerLevel())
                    .developerSkillLevel(developer.getDeveloerSkillLevel())
                    .experienceYears(developer.getExperienceYears())
                    .memberId(developer.getMemberId())
                    .build();
        }
    }
}
