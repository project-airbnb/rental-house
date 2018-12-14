package com.PKHS.airbnb.service.impl;

import com.PKHS.airbnb.model.Image;
import com.PKHS.airbnb.repository.UploadFileRepository;
import com.PKHS.airbnb.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadFileServiceImpl implements UploadFileService {
    @Autowired
    private UploadFileRepository uploadFileRepository;

    @Override
    public void save(Image image) {
        this.uploadFileRepository.save(image);
    }
}
