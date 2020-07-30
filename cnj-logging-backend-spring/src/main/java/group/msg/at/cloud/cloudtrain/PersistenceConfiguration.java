package group.msg.at.cloud.cloudtrain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.security.Principal;
import java.util.Optional;

/**
 * Persistence configuration which initializes Spring Data JPA properly.
 * <p>
 * Represents a producer for AuditorAware<T> instances as well which are needed by the
 * {@code AuditingEntityListener} of Spring Data. In this showcase we simply deal with user IDs
 * for {@code createdBy} and {@code lastModifiedBy} not full-blown user entities.
 * </p>
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing
public class PersistenceConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityBasedAuditorAware();
    }

    private static class SpringSecurityBasedAuditorAware implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() {
            Optional<String> result = Optional.of("anonymous");
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication.isAuthenticated()) {
                result = Optional.of(authentication.getName());
            }
            return result;
        }
    }
}
