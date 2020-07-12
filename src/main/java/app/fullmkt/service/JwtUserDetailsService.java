package app.fullmkt.service;

import java.util.ArrayList;

import app.fullmkt.entity.Cliente;
import app.fullmkt.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import com.javainuse.dao.UserDao;
//import com.javainuse.model.DAOUser;
//import com.javainuse.model.UserDTO;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente usuario = clienteRepository.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getSenha(),
                new ArrayList<>());
    }

}
