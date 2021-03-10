package ru.itcrown.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itcrown.models.Role;
import ru.itcrown.models.User;
import ru.itcrown.repositories.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService, Listener {

    private final UserRepository userRepository;
    private final Map<Long, User> userMap = new ConcurrentHashMap<>();
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }


    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public void notify(String msg) {
        System.out.println("notify");
    }

    @Override
    public List<User> findAll() {

        Map<Long, User> userMapFromRepository = userRepository.findAll();
        userMap.clear();
        userMap.putAll(userMapFromRepository);
        return userMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void saveOrUpdate(User user) {
        userRepository.save(user);
        userMap.put(user.getId(), user);
    }

    @Override
    public void removeById(Long id) {
        userRepository.remove(id);
        userMap.remove(id);

    }

    @Override
    public User findByUsername(String username) {

        return userRepository.findByUsername(username);

    }

    @Override
    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public void addRoleToUser(User user, Role role) {
        userMap.get(user.getId()).addRole(role);
        userRepository.save(userMap.get(user.getId()));
    }

    @Override
    public void removeRoleFromUser(User user, Role role) {
        userMap.get(user.getId()).removeRole(role);
        userRepository.save(userMap.get(user.getId()));
    }

    @Override
    public User findById(Long id) {

        User user = userRepository.findById(id);
        if (!userMap.containsValue(user)) findAll();
        return userMap.get(id);
    }
}
