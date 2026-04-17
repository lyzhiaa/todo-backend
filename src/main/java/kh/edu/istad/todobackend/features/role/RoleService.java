package kh.edu.istad.todobackend.features.role;



import kh.edu.istad.todobackend.features.role.dto.RoleCreateRequest;
import kh.edu.istad.todobackend.features.role.dto.RoleResponse;
import kh.edu.istad.todobackend.features.role.dto.RoleUpdateRequest;

import java.util.List;

public interface RoleService {
    // create role
    RoleResponse createRole(RoleCreateRequest roleCreateRequest);
    // get all roles
    List<RoleResponse> getAllRoles();
    // get role by id
    RoleResponse getRoleByUuid(String uuid);
    // update role
    RoleResponse updateRoleByUuid(String uuid, RoleUpdateRequest roleUpdateRequest);
    // delete role
    void deleteRoleByUuid(String uuid);
}
