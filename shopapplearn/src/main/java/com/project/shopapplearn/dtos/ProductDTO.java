package com.project.shopapplearn.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


public class ProductDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters")
    private String name;

    @Min(value = 0, message = "Price must be greater than 0")
    @Max(value = 100000000, message = "Price must be less than 100000000")
    private Float price;
    private String description;
    private String thumbnail;

    @JsonProperty("category_id")
    private String categoryId;

    public ProductDTO() {
    }

    public ProductDTO(String name, Float price, String description, String thumbnail, String categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.categoryId = categoryId;
    }

    public @NotBlank(message = "Name is required") @Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") @Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters") String name) {
        this.name = name;
    }

    public @Min(value = 0, message = "Price must be greater than 0") @Max(value = 100000000, message = "Price must be less than 100000000") Float getPrice() {
        return price;
    }

    public void setPrice(@Min(value = 0, message = "Price must be greater than 0") @Max(value = 100000000, message = "Price must be less than 100000000") Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }
}
