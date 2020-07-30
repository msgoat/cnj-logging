package group.msg.at.cloud.cloudtrain.adapter.rest.grantedpermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class RestTemplateGrantedPermissionsClient implements GrantedPermissionsClient {

    /**
     * Inject a {@code RestTemplateBuilder} instead of a {@code RestTemplate}
     * to be able to create a RestTemplate with some common configuration and
     * some endpoint specific configuration.
     */
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    /**
     * Inject configuration property with downstream service base URL.
     */
    @Value("${cloudtrain.services.downstream.url}")
    String downstreamServiceUrl;

    /**
     * RestTemplate to be used to call downstream service.
     */
    RestTemplate restTemplate;

    /**
     * Build a {@code RestTemplate} using the provided {@code RestTemplateBuilder}.
     */
    @PostConstruct
    public void onPostConstruct() {
        restTemplate = restTemplateBuilder.rootUri(downstreamServiceUrl).build();
    }

    @Override
    public List<GrantedPermission> getGrantedPermissionsByCurrentUser() {
        GrantedPermission[] found = restTemplate.getForObject("/api/v1/grantedPermissions", GrantedPermission[].class);
        return Arrays.asList(found);
    }
}
