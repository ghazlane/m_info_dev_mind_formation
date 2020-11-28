package com.ghazlane.projectweb.web_project_ghazlane;

import com.ghazlane.projectweb.web_project_ghazlane.hello.GreetingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// annotate this class to mark it as a configuration bean
@Configuration
public class WebProjectGhazlaneApplicationConfig {
    // Add annotation to say that this method return a new Bean Spring
    @Bean
    public CommandLineRunner greetingCommandLine(GreetingService greetingService) { // Then, tell Spring that here we need here a GreetingService component, by declaring it as a method argument
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                greetingService.greet("Spring");
            }
        };
    }
}
