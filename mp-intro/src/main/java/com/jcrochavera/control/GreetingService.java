package com.jcrochavera.control;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by julio.rocha on 28/11/19.
 *
 * @author julio.rocha
 */
@ApplicationScoped
public class GreetingService {
    @Inject
    @ConfigProperty(name = "mp.user.name", defaultValue = "John Doe")
    Provider<String> userName;
    int i = 0;

    @Counted(name = "userNameFromConfig")
    @Timed(name = "buildReferenceListAllTimer")
    public String getUserName() {
        return userName.get();
    }

    @Retry(maxRetries = 4, retryOn = RuntimeException.class)
    @Fallback(fallbackMethod = "defaultGreeting")
    public String getGreetingFaultTolerant() {
        i++;
        System.out.println("trying to return a greeting. " + i);
        if (i > 3) {
            throw new RuntimeException("");
        }
        return "Greetings from no failure method... ";
    }

    public String defaultGreeting() {
        if (i > 15) {
            i = 0;
        }
        return "Greeting from default method :|";
    }
}
