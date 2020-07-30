package group.msg.at.cloud.cloudtrain.core.entity;

import java.util.ArrayList;
import java.util.List;

public class GrantedPermission {

    private String permission;

    public GrantedPermission(Permission permission) {
        this.permission = permission.getPermissionName();
    }

    public String getPermission() {
        return permission;
    }
}
