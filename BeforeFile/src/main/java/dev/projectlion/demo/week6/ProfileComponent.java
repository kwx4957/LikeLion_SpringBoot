package dev.projectlion.demo.week6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("local")
@Component
public class ProfileComponent {
    private static final Logger logger = LoggerFactory.getLogger(ProfileComponent.class);
    public ProfileComponent() {
        logger.info("profile component this is local profile");
    }
}
