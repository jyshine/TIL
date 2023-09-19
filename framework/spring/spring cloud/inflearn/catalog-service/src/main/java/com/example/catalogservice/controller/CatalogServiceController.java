package com.example.catalogservice.controller;

import com.example.catalogservice.response.ResponseCatalog;
import com.example.catalogservice.service.CatalogService;
import com.example.catalogservice.vo.CatalogDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("catalog-service")
public class CatalogServiceController {

    Environment environment;
    CatalogService catalogService;

    @Autowired
    public CatalogServiceController(Environment environment, CatalogService catalogService) {
        this.environment = environment;
        this.catalogService = catalogService;
    }

    @GetMapping("/health-check")
    public String healthCheck(){
        return String.format("CatalogService Port %s", environment.getProperty("local.server.port"));
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getAllCatalog(){
        List<CatalogDTO> allCatalogs = catalogService.getAllCatalogs();
        List<ResponseCatalog> responseCatalogList = new ArrayList<>();
        allCatalogs.forEach(catalogDTO -> {
            responseCatalogList.add(new ModelMapper().map(catalogDTO,ResponseCatalog.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(responseCatalogList);
    }
}
