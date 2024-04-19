package com.mh.mychart.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public PersonDto getPersonById(Long id) {
        Person person= personRepository.findById(id).orElseThrow();
        return PersonDto.builder()
            .name(person.getName())
            .age(person.getAge())
            .build();
    }
}
