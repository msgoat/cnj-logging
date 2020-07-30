package group.msg.at.cloud.cloudtrain.adapter.rest.grantedpermissions;

import java.util.List;

public interface GrantedPermissionsClient {

    List<GrantedPermission> getGrantedPermissionsByCurrentUser();

}
