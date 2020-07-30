package group.msg.at.cloud.cloudtrain.adapter.security;

import group.msg.at.cloud.common.security.config.AbstractOidcResourceServerConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Spring Security OAuth2 web security configuration.
 * <p>
 * All REST endpoints except the actuator REST endpoints are protected by role {@code CLOUDTRAIN_USER}
 * which is assigned to all authenticated users of this application when logging in on Keycloak.
 * </p>
 * <p>
 * More specific endpoint URI to role mappings can be added to {@link #configure(HttpSecurity)}.
 * </p>
 * <p>
 * Before this application may use Keycloak as an OpenID Connect provider, this application must be registered as
 * an OpenID Connect client with Keycloak.
 * </p>
 *
 * @author michael.theis@msg.group
 * @version 2.0
 * @since 3.0.0
 */
@EnableWebSecurity
public class WebSecurityConfiguration extends AbstractOidcResourceServerConfiguration {

    /**
     * Defines the security rules applied to different request URIs.
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers("/api/v1/grantedPermissions", "/api/v1/grantedPermissions/**").hasRole("CLOUDTRAIN_USER"))
                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter());
    }
}
