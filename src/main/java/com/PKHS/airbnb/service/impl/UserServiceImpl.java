package com.PKHS.airbnb.service.impl;
import com.PKHS.airbnb.model.User;
import com.PKHS.airbnb.repository.UserRepository;
import com.PKHS.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<User> fillAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void remove(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Page<User> findByName(String name, Pageable pageable) {
        return userRepository.findAllByUsernameContaining(name,pageable);
    }
}
