package group.msg.at.cloud.cloudtrain.core.control;

import group.msg.at.cloud.cloudtrain.adapter.rest.grantedpermissions.GrantedPermission;
import group.msg.at.cloud.cloudtrain.adapter.rest.grantedpermissions.GrantedPermissionsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPermissionVerifier {

    @Autowired
    GrantedPermissionsClient client;

    public boolean hasPermission(String permission) {

        List<GrantedPermission> permissions = client.getGrantedPermissionsByCurrentUser();
        for (GrantedPermission current : permissions) {
            if (current.getPermission().equals(permission)) {
                return true;
            }
        }

        return false;
    }

    public void requirePermission(String permission) {
        if (!hasPermission(permission)) {
            throw new IllegalStateException(String.format("missing required permission [%s] for user [%s]", permission, SecurityContextHolder.getContext().getAuthentication().getName()));
        }
    }
}
