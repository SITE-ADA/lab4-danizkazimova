package az.edu.ada.wm2.lab4.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Product {
    private String productName;
    private UUID id;
    private LocalDate expirationDate;
    private BigDecimal price;

    public Product(){
        this.id=UUID.randomUUID();
    }

    public Product(String productName, LocalDate expirationDate, BigDecimal price){
        this.id=UUID.randomUUID();
        this.productName=productName;
        this.expirationDate=expirationDate;
        this.price=price;
    }

    public Product(UUID id,String productName, LocalDate expirationDate, BigDecimal price){
        this.id=id;
        this.productName=productName;
        this.expirationDate=expirationDate;
        this.price=price;
    }

    public UUID getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
