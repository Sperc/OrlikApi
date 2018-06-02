package com.sosnowka.controller;

import com.sosnowka.model.Picture;
import com.sosnowka.service.PictureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Pawel on 25.02.2018.
 */
@RestController
@RequestMapping("/pictures")
public class PictureController {
    @Autowired
    PictureService pictureService;

    @Autowired
    String getDirecotryPath;

    @GetMapping(value = "{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public HttpEntity<byte[]> getArticleImage(@PathVariable Long id) {

        Picture picture = pictureService.findById(id);
        if (picture == null) return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);

        Path path = Paths.get(getDirecotryPath + picture.getName());
        byte[] image = new byte[0];
        try {
            image = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);
        return new HttpEntity<byte[]>(image, headers);
    }

}
