package main.java.com.taskcli.service;

import main.java.com.taskcli.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {



        User create(CreateUserRequest req);

        User update(UUID userId, UpdateUserRequest req);

        Optional<User> getById(UUID userId);

        Optional<User> getByEmail(String email);

        List<User> list(String text);

        void delete(UUID userId);

        // DTOs
        record CreateUserRequest(String name, String email) {}
        record UpdateUserRequest(String name, String email) {}
    }

    /*
    registerUser(...)
findUserByName(...)
authenticateUser(...)
deleteUser(...)

     */

