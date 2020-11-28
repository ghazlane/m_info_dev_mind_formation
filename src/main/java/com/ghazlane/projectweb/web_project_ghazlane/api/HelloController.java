package com.ghazlane.projectweb.web_project_ghazlane.api;

import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

//Today browsers forbid a website to access to resources served by another website defined on a different domain
@CrossOrigin //@CrossOrigin(origins = { "http://localhost:3010" }, maxAge = 3600)
@RestController
@RequestMapping("/api/hello")
@Transactional
public class HelloController {

    @GetMapping("/{name}")
    public MessageDto welcome(@PathVariable String name) {
        return new MessageDto("Hello " + name);
    }

    class MessageDto {
        String message;

        public MessageDto(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
