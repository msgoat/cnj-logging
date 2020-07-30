package group.msg.at.cloud.cloudtrain.adapter.rest.grantedpermissions;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Rest client for the {@code GrantedPermissions} service provided by an external application.
 * <p>
 * Uses the MicroProfile REST Client feature: you only provide a client interface with
 * JAX-RS annotations and the MP REST Client feature maps Java calls to REST calls on the fly.
 * </p>
 * <p>
 * Please note that all configuration parameters like base URL, timeouts etc are bound to a
 * specific property namespace {@code cloudtrain.service.grantedpermissions} to avoid
 * excessively long property names based on the fully qualified type name of the REST client interface.
 * </p>
 */
@RegisterRestClient(configKey = "cloudtrain.services.grantedpermissions")
@Path("api/v1/grantedPermissions")
public interface GrantedPermissionsClient {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<GrantedPermission> getGrantedPermissionsByCurrentUser();
}
