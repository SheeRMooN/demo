package ru.vlasov.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlasov.entity.UserEntity;
import ru.vlasov.exception.UserNotFoundException;
import ru.vlasov.service.UserService;
import ru.vlasov.view.Views;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @JsonView({Views.Name.class})
    public ResponseEntity getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("{id}")
    @JsonView({Views.Name.class})
    public ResponseEntity getUserById(@PathVariable("id") Long id) {
        try {
            UserEntity user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(NOT_FOUND);
        }
    }

    @GetMapping(path = "records/{id}")
    @JsonView({Views.number.class})
    public ResponseEntity getAllRecordsForUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getAllRecordsForUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(NOT_FOUND);
        }
    }

    @GetMapping(path = "find")
    @JsonView({Views.Name.class})
    public ResponseEntity getUserByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(userService.getUserByName(name));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(NOT_FOUND);
        }
    }

    @GetMapping(path = "findbypart")
    @JsonView({Views.Name.class})
    public ResponseEntity getUserByNamePart(@RequestParam String part) {
        try {
            return ResponseEntity.ok(userService.getUserByNamePart(part));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(NOT_FOUND);
        }
    }

    @PostMapping
    @JsonView({Views.Name.class})
    public ResponseEntity createUser(@RequestBody UserEntity user) {
        userService.create(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    @JsonView({Views.Name.class})
    public ResponseEntity update(@RequestParam Long id
            , @RequestBody UserEntity user) {
        try {
            return ResponseEntity.ok(userService.update(id, user));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    @JsonView({Views.Name.class})
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            UserEntity user = userService.delete(id);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(NOT_FOUND);
        }
    }
}
