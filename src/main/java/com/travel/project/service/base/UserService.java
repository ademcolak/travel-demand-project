package com.travel.project.service.base;

import com.travel.project.controller.model.request.CrmUser;
import com.travel.project.entity.User;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

   Optional<User> findByUserName(String userName);

   void save(CrmUser crmUser);
}