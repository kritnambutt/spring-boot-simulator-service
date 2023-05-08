package com.aiaplushk.controllers;

import com.aiaplushk.helpers.FileReader;
import com.aiaplushk.server.api.UsersApiDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserController implements UsersApiDelegate {
    private final FileReader fileReader;

    public UserController(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public ResponseEntity<String> getAllUsers() {
        // add controller logic here for validation, error handling etc.
        String response = fileReader.getResponse("get-all-users-response.json");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
