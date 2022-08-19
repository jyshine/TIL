package com.example.catalogservice.service;

import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.repository.CatalogRepository;
import com.example.catalogservice.vo.CatalogDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    CatalogRepository catalogRepository;

    @Override
    public List<CatalogDTO> getAllCatalogs() {
        Iterable<CatalogEntity> allCatalogEntity = catalogRepository.findAll();

        List<CatalogDTO> catalogDTOList = new ArrayList<>();

        allCatalogEntity.forEach(
                catalogEntity -> catalogDTOList.add(new ModelMapper().map(catalogEntity, CatalogDTO.class))
        );

        return catalogDTOList;
    }
}
