package com.epam.spring.core.mvc.controllers.services;

import com.epam.spring.core.domain.User;
import com.epam.spring.core.parsers.Converter;
import com.epam.spring.core.parsers.UsersParser;
import com.epam.spring.core.services.interfaces.UserService;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("fileService")
public class FileService {
    
    @Autowired
    private UserService userService;

    public void parseFiles(Map<String, MultipartFile> files)
            throws IOException {
        for (String key :
                files.keySet()) {
            if (key.equals("users")) {
                String data = Converter.read(files.get(key).getInputStream());
                for(User curUser: UsersParser.getUserList(data)){
                    userService.register(curUser);
                }
            }
        }
    }
}
