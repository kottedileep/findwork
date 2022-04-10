package com.fwork.services;
import java.util.ArrayList;

import com.fwork.model.Freelancer;
import com.fwork.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    FreelancerRepository freelancerRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Freelancer user = freelancerRepository.findByEmailId(userName);
        return new User(user.getEmailId(),user.getPasswd(),new ArrayList<>());
    }
}
