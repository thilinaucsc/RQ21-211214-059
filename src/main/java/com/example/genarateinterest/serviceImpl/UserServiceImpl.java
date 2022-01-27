package com.example.genarateinterest.serviceImpl;

import com.example.genarateinterest.dto.LoginRequest;
import com.example.genarateinterest.dto.LoginResponse;
import com.example.genarateinterest.dto.Usr;
import com.example.genarateinterest.entity.Customer;
import com.example.genarateinterest.repository.CustomerRepository;
import com.example.genarateinterest.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final CustomerRepository customerRepository;

    public UserServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public LoginResponse loginResponseMapping(String jwt, LoginRequest loginRequest) {

        return new LoginResponse(jwt, userToUsrMapping(loginRequest.getUsername()));
    }


    private Usr userToUsrMapping(String username) {
        Customer user = customerRepository.findByUsernameAndTerminatedDateIsNull(username).orElseThrow(() ->
                new UsernameNotFoundException("LoginUser not found with username : " + username)
        );

        Usr usr = new Usr();
        usr.setAvatar("/assets/images/face-6.jpg");
        usr.setEmail("email");
        usr.setId(user.getId());
        user.getRoles().forEach(role -> usr.setRole(role.getName()));
        usr.setName(user.getName());
        usr.setUsername(user.getUsername());

        return usr;
    }
}
