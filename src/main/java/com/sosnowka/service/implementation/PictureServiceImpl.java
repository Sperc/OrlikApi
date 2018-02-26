package com.sosnowka.service.implementation;

import com.sosnowka.model.Picture;
import com.sosnowka.repository.PictureReposiotry;
import com.sosnowka.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Pawel on 24.02.2018.
 */
@Service
public class PictureServiceImpl implements PictureService {
//    private static String DIRECTORY_PICTURE_PATH = "./src/main/resources/static/";
    @Autowired
    String getDirectoryPicturePath;

    @Autowired
    private PictureReposiotry pictureReposiotry;

    @Override
    public Picture storagePhoto(byte[] bytes, String username) {
        BufferedImage image = null;
        String fileName = String.valueOf(new Date().getTime()) + ".jpg";
        String filePath = getDirectoryPicturePath + fileName;

        File outpFile = new File(filePath);

        try {
            image = ImageIO.read(new ByteArrayInputStream(bytes));
            ImageIO.write(image, "jpg", outpFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picture picture = new Picture();
        picture.setName(fileName);
        return picture;
    }

    @Override
    public Picture findById(Long id) {
        return pictureReposiotry.findById(id);
    }

    @Override
    public Picture findByName(String name) {
        return pictureReposiotry.findByName(name);
    }
}
