package com.example.dmaker.service;

import com.example.dmaker.dto.CreateDeveloper;
import com.example.dmaker.entity.Developer;
import com.example.dmaker.exception.DMakerException;
import com.example.dmaker.repository.DeveloperRepository;
import com.example.dmaker.type.DeveloperLevel;
import com.example.dmaker.type.DeveloperSkillLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.example.dmaker.exception.DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    @Transactional
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request) {
        validateCreateDeveloperRequest(request);

        Developer developer = Developer.builder()
                .develoerLevel(request.getDeveloperLevel())
                .develoerSkillLevel(request.getDeveloperSkillLevel())
                .experienceYears(request.getExperienceYears())
                .memberId(request.getMemberId())
                .name(request.getName())
                .age(request.getAge())
                .build();

        developerRepository.save(developer);
        return new CreateDeveloper.Response().fromEntity(developer);
    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYears = request.getExperienceYears();
        if (developerLevel == DeveloperLevel.SENIOR
                && experienceYears < 10) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNGNIOR
                && (experienceYears < 4 || experienceYears > 10)) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNIOR && experienceYears > 4) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        developerRepository.findByMemberId(request.getMemberId())
                .ifPresent((developer -> {
                    throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
                }));
    }
}
