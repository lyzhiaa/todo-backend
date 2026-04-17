package kh.edu.istad.todobackend.features.role;

import kh.edu.istad.todobackend.domain.Role;
import kh.edu.istad.todobackend.features.role.dto.RoleCreateRequest;
import kh.edu.istad.todobackend.features.role.dto.RoleResponse;
import kh.edu.istad.todobackend.features.role.dto.RoleUpdateRequest;
import kh.edu.istad.todobackend.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    // create role
    @Override
    public RoleResponse createRole(RoleCreateRequest roleCreateRequest) {
        if (roleRepository.existsByName(roleCreateRequest.name())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This role already exists");
        }
        Role role = roleMapper.fromRoleCreateRequest(roleCreateRequest);
        role.setName("ROLE_" + roleCreateRequest.name().toUpperCase());
        role.setUuid(UUID.randomUUID().toString());
        roleRepository.save(role);

        return roleMapper.toRoleResponse(role);
    }

    // get all roles
    @Override
    public List<RoleResponse> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roleMapper.toRoleResponseList(roles);
    }

    // get role by uuid
    @Override
    public RoleResponse getRoleByUuid(String uuid) {
        Role role = roleRepository.findByUuid(uuid)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found"));
        return roleMapper.toRoleResponse(role);
    }

    // update role by name
    @Override
    public RoleResponse updateRoleByUuid(String uuid, RoleUpdateRequest roleUpdateRequest) {
        Role role = roleRepository.findByUuid(uuid)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found"));
        roleMapper.fromRoleUpdateRequest(roleUpdateRequest, role);
        role.setName("ROLE_" + roleUpdateRequest.name().toUpperCase());
        roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    // delete role
    @Override
    public void deleteRoleByUuid(String uuid) {
        Role role = roleRepository.findByUuid(uuid)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found"));
        roleRepository.delete(role);
    }
}
