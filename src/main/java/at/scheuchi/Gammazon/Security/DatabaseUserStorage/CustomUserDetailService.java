package at.scheuchi.Gammazon.Security.DatabaseUserStorage;

import at.scheuchi.Gammazon.Model.User;
import at.scheuchi.Gammazon.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);
        if(user == null)
            throw new UsernameNotFoundException(s);
        return new CustomUserPrincipal(user);
    }
}
