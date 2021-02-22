package project.component;

import org.springframework.stereotype.Component;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


@Component
public class LoginUserAuditorAware implements AuditorAware<String>{
    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.of("AdminServer");
    }
}