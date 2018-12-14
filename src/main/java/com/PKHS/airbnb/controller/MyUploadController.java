package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.Image;
import com.PKHS.airbnb.service.UploadFileService;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/image")
public class MyUploadController {
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/image";

    @Autowired
    private UploadFileService uploadFileService;

    @GetMapping
    public String listImage() {
        return "upload/list_images";
    }

    @GetMapping("/upload")
    public String uploadImage(Model model) {
        model.addAttribute("image", new Image());
        return "upload/upload";
    }

    @PostMapping("/upload")
    public String saveImages(Model model, @RequestParam("files") MultipartFile[] files) {
        StringBuilder file_name = new StringBuilder();
        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());

            //save database
            String name = file.getOriginalFilename();
            String link = "image/" + name ;
            Image newImage = new Image(name, link);
            this.uploadFileService.save(newImage);
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        model.addAttribute("url", uploadDirectory);
        model.addAttribute("message", "upload done ");
        return "upload/upload";
    }
}
