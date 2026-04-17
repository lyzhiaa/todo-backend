package kh.edu.istad.todobackend.mapper;

import kh.edu.istad.todobackend.domain.Role;
import kh.edu.istad.todobackend.features.role.dto.RoleCreateRequest;
import kh.edu.istad.todobackend.features.role.dto.RoleResponse;
import kh.edu.istad.todobackend.features.role.dto.RoleUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    // create role
    Role fromRoleCreateRequest(RoleCreateRequest roleCreateRequest);
    // get role by id
    RoleResponse toRoleResponse(Role role);
    // get all roles
    List<RoleResponse> toRoleResponseList(List<Role> roles);
    // update role
    void fromRoleUpdateRequest(RoleUpdateRequest roleUpdateRequest, @MappingTarget Role role);

}
