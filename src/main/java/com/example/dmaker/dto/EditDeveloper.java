package com.example.dmaker.dto;

import com.example.dmaker.type.DeveloperLevel;
import com.example.dmaker.type.DeveloperSkillLevel;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class EditDeveloper {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request {
        @NotNull
        private DeveloperLevel developerLevel;
        @NotNull
        private DeveloperSkillLevel developerSkillLevel;
        @NotNull
        @Min(0)
        @Max(20)
        private Integer experienceYears;

    }
}
