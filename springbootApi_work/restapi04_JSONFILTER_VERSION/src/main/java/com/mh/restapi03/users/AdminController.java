package com.mh.restapi03.users;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.mh.restapi03.exception.ErrorCode;
import com.mh.restapi03.exception.UsersException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    // IOC 컨테이너 객체 가져오는 방법
    // Autowired 이거 안쓰고..
    private final UserRepository userRepository;

    @GetMapping("users/{id}")
    public MappingJacksonValue getUserByID(@PathVariable Long id){

//        Optional<User> user = userRepository.findById(id);
//        if(user.isEmpty())
//            throw new UsersException(ErrorCode.NOTFOUND);

        User user = userRepository.findById(id).orElseThrow(
                () -> new UsersException(ErrorCode.NOTFOUND)
        );

        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(user,adminUser);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(adminUser);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("AdminUser",
                    SimpleBeanPropertyFilter.filterOutAllExcept("username","email","password")
                );
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @DeleteMapping("users/{id}")
    public User deleteUserById(Long id){

        return new User();
    }

}
