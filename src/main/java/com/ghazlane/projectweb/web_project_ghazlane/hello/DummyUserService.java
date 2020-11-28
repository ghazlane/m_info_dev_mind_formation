package com.ghazlane.projectweb.web_project_ghazlane.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DummyUserService implements UserService {

    GreetingService greetingService;

    @Autowired
    public DummyUserService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void greetAll() {
        // Map<String, String> listElement = new HashMap<>();
        // listElement.put("key1","value1");

        List<String> listElement = new ArrayList<>();
        listElement.add("Elodie");
        listElement.add("Charles");

        for (String element : listElement) {
            this.greetingService.greet(element);
        }
    }
}
