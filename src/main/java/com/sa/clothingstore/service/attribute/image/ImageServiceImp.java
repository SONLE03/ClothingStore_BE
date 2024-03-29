package com.sa.clothingstore.service.attribute.image;

import com.sa.clothingstore.common.exception.ObjectNotFoundException;
import com.sa.clothingstore.dto.request.attribute.ImageRequest;
import com.sa.clothingstore.dto.response.attribute.ImageResponse;
import com.sa.clothingstore.dto.response.category.BranchResponse;
import com.sa.clothingstore.model.attribute.Image;
import com.sa.clothingstore.model.category.Branch;
import com.sa.clothingstore.repository.attribute.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImp implements ImageService {
    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;
    @Override
    public ImageResponse createImage(ImageRequest imageRequest) {
        return modelMapper
                .map(imageRepository
                                .save(modelMapper
                                        .map(imageRequest, Image.class))
                        , ImageResponse.class);
    }

    @Override
    public Image modifyImage(UUID id, ImageRequest imageRequest) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Image not found")
                );
        image.setUrl(imageRequest.getUrl());
        return imageRepository.save(image);
    }

    @Override
    public void deleteImage(UUID id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Image not found")
                );
        imageRepository.delete(image);
    }

    @Override
    public Image getById(UUID id) {
        return null;
    }

    @Override
    public List<Image> getAllImage() {
        return imageRepository.findAll();
    }
}
