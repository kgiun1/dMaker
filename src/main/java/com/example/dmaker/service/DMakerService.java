package com.example.dmaker.service;

import com.example.dmaker.entity.Developer;
import com.example.dmaker.repository.DeveloperRepository;
import com.example.dmaker.type.DeveloperLevel;
import com.example.dmaker.type.DeveloperSkillLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    @Transactional
    public void createDeveloper(){
        Developer developer = Developer.builder()
                .develoerLevel(DeveloperLevel.JUNIOR)
                .develoerSkillLevel(DeveloperSkillLevel.FRONT_END)
                .experienceYears(2)
                .name("Olaf")
                .age(5)
                .build();

        developerRepository.save(developer);
    }
}
