
package com.panaskin.cacheapp.service;

import com.panaskin.cacheapp.dto.UserDto;
import com.panaskin.cacheapp.entity.User;

public interface UserAssembler {
    User assemble(UserDto dto);
    UserDto assemble(User entity);
}

