package com.epam.spring.core.mvc.controllers;

import com.epam.spring.core.mvc.controllers.services.FileService;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @SuppressWarnings("finally")
    @RequestMapping(value = "/uploadJson", method = RequestMethod.POST)
    public ModelAndView fileUpload(MultipartHttpServletRequest req) throws IOException {
        Map<String, MultipartFile> files = req.getFileMap();
         if (!files.isEmpty()) {
            fileService.parseFiles(files);
        }
        return new ModelAndView("redirect:/user/getAllUsers");
    }

}
