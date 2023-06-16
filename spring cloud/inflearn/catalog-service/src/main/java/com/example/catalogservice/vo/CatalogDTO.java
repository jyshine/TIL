package com.example.catalogservice.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CatalogDTO implements Serializable {
    private String productId;
    private String productName;
    private Integer stock;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    private Date createdAt;

}
