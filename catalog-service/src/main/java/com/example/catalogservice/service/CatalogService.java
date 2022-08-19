package com.example.catalogservice.service;

import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.vo.CatalogDTO;

import java.util.List;

public interface CatalogService {
    List<CatalogDTO> getAllCatalogs();
}
