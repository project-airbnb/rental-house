package com.PKHS.airbnb.repository;

import com.PKHS.airbnb.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface UploadFileRepository extends CrudRepository<Image, Integer> {
}
