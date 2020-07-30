package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.cloudtrain.core.boundary.GrantedPermissionManager;
import group.msg.at.cloud.cloudtrain.core.entity.GrantedPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/grantedPermissions")
@CrossOrigin
public class GrantedPermissionsController {

    @Autowired
    GrantedPermissionManager boundary;

    @GetMapping
    public ResponseEntity<List<GrantedPermission>> getPermissionsByCurrentUser() {
        return ResponseEntity.ok(this.boundary.getGrantedPermissionsByCurrentUser());
    }
}
