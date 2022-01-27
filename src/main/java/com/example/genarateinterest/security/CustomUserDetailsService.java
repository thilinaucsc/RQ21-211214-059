package com.example.genarateinterest.security;

import com.example.genarateinterest.entity.Customer;
import com.example.genarateinterest.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public CustomUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Customer user = customerRepository.findByUsernameAndTerminatedDateIsNull(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("LoginUser not found with username : " + username)
                );

        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        Customer user = customerRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("LoginUser not found with id : " + id)
        );

        return UserPrincipal.create(user);
    }
}