package sit.integrated.project.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sit.integrated.project.models.JwtUser;
import sit.integrated.project.repositories.JwtUserRepositories;

@Service
public class JwtUserDetailService implements UserDetailsService {

    JwtUserRepositories JwtRepository;


    @Override
    public UserDetails loadUserByUsername(String usernames) throws UsernameNotFoundException {
        JwtUser user = JwtRepository.findById(usernames).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username:" +usernames));
        return  user;
    }

}
