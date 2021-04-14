package ru.vlasov.service;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlasov.entity.RecordEntity;
import ru.vlasov.entity.UserEntity;
import ru.vlasov.exception.UserNotFoundException;
import ru.vlasov.repository.UserRepo;
import ru.vlasov.view.Views;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<UserEntity> getAllUser() {
        return userRepo.findAll();
    }

    public UserEntity getUserById(Long id) throws UserNotFoundException {
        return findUserById(id);
    }

    public List<UserEntity> getUserByName(String name) throws UserNotFoundException {
        List<UserEntity> users = new ArrayList<>(userRepo.findAllById(name));
        if(users.isEmpty()) {
            throw new UserNotFoundException();
        }
        return users;
    }

    public List<UserEntity> getUserByNamePart(String part) throws UserNotFoundException {
        List<UserEntity> users = new ArrayList<>(userRepo.findAllByNameContains(part));
        if(users.isEmpty()) {
            throw new UserNotFoundException();
        }
        return users;
    }

    public List<RecordEntity> getAllRecordsForUser(Long id) throws UserNotFoundException {
        return findUserById(id).getRecords();
    }

    public UserEntity create(UserEntity user) {
        return userRepo.save(user);
    }

    public UserEntity update(Long id, UserEntity user) throws UserNotFoundException {
        UserEntity userFromDb = findUserById(id);
        if (user != null) {
            userFromDb.setFirstName(user.getFirstName());
            userFromDb.setLastName(user.getLastName());
            userFromDb.setAge(user.getAge());
            userFromDb.setGender(user.isGender());
            userFromDb.setRecords(user.getRecords());
            userRepo.save(userFromDb);
        }
        return userFromDb;
    }

    public UserEntity delete(Long id) throws UserNotFoundException {
        UserEntity userFromDb = findUserById(id);
        userRepo.delete(userFromDb);
        return userFromDb;
    }

    private UserEntity findUserById(Long id) throws UserNotFoundException {
        return userRepo.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
