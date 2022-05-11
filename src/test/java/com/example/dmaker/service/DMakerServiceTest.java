package com.example.dmaker.service;

import com.example.dmaker.dto.DeveloperDetailDto;
import com.example.dmaker.entity.Developer;
import com.example.dmaker.repository.DeveloperRepository;
import com.example.dmaker.repository.RetiredDeveloperRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.dmaker.type.DeveloperLevel.SENIOR;
import static com.example.dmaker.type.DeveloperSkillLevel.FRONT_END;
import static com.example.dmaker.type.StatusCode.EMPLOYED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class DMakerServiceTest {
    @Mock
    private DeveloperRepository developerRepository;

    @Mock
    private RetiredDeveloperRepository retiredDeveloperRepository;

    @InjectMocks
    private DMakerService dMakerService;

    @Test
    public void testSomething() {
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.of(Developer.builder()
                        .develoerLevel(SENIOR)
                        .develoerSkillLevel(FRONT_END)
                        .experienceYears(12)
                        .statusCode(EMPLOYED)
                        .name("name")
                        .age(32)
                        .build()));

        DeveloperDetailDto developerDetail = dMakerService.getDeveloperDetail("meberId");

        assertEquals(SENIOR, developerDetail.getDeveloerLevel());
        assertEquals(FRONT_END, developerDetail.getDeveloerSkillLevel());
        assertEquals(12, developerDetail.getExperienceYears());
    }
}