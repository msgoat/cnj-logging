package group.msg.at.cloud.cloudtrain.core.control;

import group.msg.at.cloud.cloudtrain.core.entity.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Simplest possible {@code Repository} implementation based on a Map.
 */
@Service
public class PermissionRepository {

    private final List<Permission> permissions = new ArrayList<>();

    @PostConstruct
    public void onPostConstruct() {
        permissions.add( new Permission("TASK_CREATE", "*", "*"));
        permissions.add( new Permission("TASK_READ", "*", "*"));
        permissions.add( new Permission("TASK_UPDATE", "*", "*"));
        permissions.add( new Permission("TASK_DELETE", "*", "*"));
    }

    public List<Permission> getPermissionsByUserAndProject(@NotNull String userName, @NotNull String projectName) {
        List<Permission> result = new ArrayList<>();
        for (Permission current : permissions) {
            if ((current.getUserName().equals(userName) || "*".equals(current.getUserName()))
                &&
                    (current.getResourceQualifier().equals(projectName) || "*".equals(current.getResourceQualifier()))) {
                result.add(current);
            }
        }
        return result;
    }

    public List<Permission> getPermissionsByUser(@NotNull String userName) {
        List<Permission> result = new ArrayList<>();
        for (Permission current : permissions) {
            if ((current.getUserName().equals(userName) || "*".equals(current.getUserName()))) {
                result.add(current);
            }
        }
        return result;
    }
}
