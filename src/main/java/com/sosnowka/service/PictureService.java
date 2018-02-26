package com.sosnowka.service;

import com.sosnowka.model.Picture;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by Pawel on 24.02.2018.
 */
@Service
public interface PictureService {
    Picture storagePhoto(byte[] bytes,String username);
    Picture findById(Long id);
    Picture findByName(String name);
}
