package kh.edu.istad.todobackend.features.role;

import jakarta.validation.Valid;
import kh.edu.istad.todobackend.features.role.dto.RoleCreateRequest;
import kh.edu.istad.todobackend.features.role.dto.RoleResponse;
import kh.edu.istad.todobackend.features.role.dto.RoleUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController {
    private final RoleService roleService;

    // create role
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    RoleResponse createRole(@Valid @RequestBody RoleCreateRequest roleCreateRequest) {
        return roleService.createRole(roleCreateRequest);
    }

    // get all roles
    @GetMapping
    List<RoleResponse> getAllRoles() {
        return roleService.getAllRoles();
    }

    // get role by uuid
    @GetMapping("/{uuid}")
    RoleResponse getRoleByUuid(@Valid @PathVariable("uuid") String uuid) {
        return roleService.getRoleByUuid(uuid);
    }

    // update role
    @PatchMapping("/{uuid}")
    RoleResponse updateRole(@PathVariable("uuid") String uuid, @Valid @RequestBody RoleUpdateRequest roleUpdateRequest) {
        return roleService.updateRoleByUuid(uuid, roleUpdateRequest);
    }

    // delete role
    @DeleteMapping("/{uuid}")
    void deleteRole(@PathVariable("uuid") String uuid) {
        roleService.deleteRoleByUuid(uuid);
    }
}
