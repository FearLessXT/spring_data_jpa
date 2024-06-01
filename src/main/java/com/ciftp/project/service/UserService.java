package com.ciftp.project.service;

import com.ciftp.project.auth.AuthRequest;
import com.ciftp.project.entities.UserEntity;
import com.ciftp.project.entities.UserRoleEntity;
import com.ciftp.project.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private static final Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserEntity> user = userRepository.findByMsisdn(username);
        if (user == null || user.size() == 0) {
            throw new UsernameNotFoundException(username + " not found");
        }

        UserEntity userEntity = user.get(0);
        Collection<GrantedAuthority> listRole = new ArrayList<>();
        return new User(userEntity.getMsisdn(), userEntity.getPassword_hash(), listRole);
    }

    public UserEntity getUserByMsisdn(String msisdn) {
        if(StringUtils.isEmpty(msisdn)) {
            throw new InvalidParameterException("msisdn is empty");
        }

        List<UserEntity> userList = userRepository.findByMsisdn(msisdn);
        if(CollectionUtils.isEmpty(userList)) {
            return null;
        } else {
            return userList.get(0);
        }
    }

    public UserEntity createUser(String msisdn,String passwordHash, UserRoleEntity userRole) {
        UserEntity user = new UserEntity();
        user.setMsisdn(msisdn);
        user.setPassword_hash(passwordHash);
        user.setRoles(null);
        userRepository.save(user);
        return user;
    }

    public void subscribeUser(AuthRequest request) {
        UserEntity user = getUserByMsisdn(request.getUsername());
        if(user == null) {
            user = createUser(request.getUsername(),request.getPassword(), null);
        } else {
            logger.debug("@Login(" + user.getMsisdn() + ")");
        }
    }
}
