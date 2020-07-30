package group.msg.at.cloud.cloudtrain.core.entity;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Represents a permission granted to a specific user for a specific resource.
 */
public class Permission {

    @NotNull
    private String permissionName;

    @NotNull
    private String resourceQualifier;

    @NotNull
    private String userName;

    /**
     * Default constructor for JSON-B.
     */
    public Permission() {

    }

    public Permission(@NotNull String permissionName, @NotNull String resourceQualifier, @NotNull String userName) {
        this.permissionName = permissionName;
        this.resourceQualifier = resourceQualifier;
        this.userName = userName;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public String getResourceQualifier() {
        return resourceQualifier;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return permissionName.equals(that.permissionName) &&
                resourceQualifier.equals(that.resourceQualifier) &&
                userName.equals(that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionName, resourceQualifier, userName);
    }

    @Override
    public String toString() {
        return "GrantedPermission{" +
                "permissionName='" + permissionName + '\'' +
                ", resourceQualifier='" + resourceQualifier + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
