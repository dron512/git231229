package org.example.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AABBService")
public class AABBService {

    @Autowired
    AA aa;

    @Autowired(required = false)
    BB bb;
}
