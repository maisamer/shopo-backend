package com.example.shopobackend.mappers;
import com.example.shopobackend.data.Role;
import com.example.shopobackend.data.ShopoUser;
import com.example.shopobackend.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface UserMapper {

    @Mappings({
            @Mapping(target = "roleName", source = "shopoUser.role.roleName"),
            @Mapping(target = "password", ignore = true)
    })
    UserDto shopoUserToUserDto(ShopoUser shopoUser);

    List<UserDto> shopoUserListToUserDtoList(List<ShopoUser> shopoUserList);

    @Mappings({
            @Mapping(target = "role.roleName", source = "userDto.roleName")
    })
    ShopoUser userDtoToShopoUser(UserDto userDto);

    private String shopoUserRoleRole(ShopoUser shopoUser) {
        Role role = shopoUser.getRole();
        if ( role == null ) {
            return null;
        }
        return role.getRoleName();
    }
}
