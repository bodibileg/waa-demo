package edu.miu.demo.service.impl;

import edu.miu.demo.domain.Role;
import edu.miu.demo.domain.User;
import edu.miu.demo.repo.RoleRepo;
import edu.miu.demo.repo.UserRepo;
import edu.miu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(userRepo.findAll());
    }

    @Override
    public User getById(long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with ID " + id + " not found."));
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(long id, User user) {

    }

    @Override
    public List<User> findByPostsGreaterThan(int num) {
        return userRepo.findByPostsGreaterThan(num);
    }

    @Override
    public void seed(List<User> users) {
        Role admin = new Role(1, "ADMIN");
        Role client = new Role(2, "CLIENT");
        roleRepo.save(admin);
        roleRepo.save(client);
        List<Role> adminList = new ArrayList<>();
        List<Role> clientList = new ArrayList<>();
        clientList.add(client);
        adminList.add(admin);
        for(int i = 0; i < users.size(); i++){
            if (i % 2 == 0) {
                users.get(i).setRoles(adminList);
            } else {
                users.get(i).setRoles(clientList);
            }
        }
        userRepo.saveAll(users);

    }


}
