package model.bean;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;
    private String color;
    private String describe;
    private Integer categoryId;

    public Product() {
    }

    public Product(Integer id, String name, Double price, Integer quantity, String color, String describe, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.describe = describe;
        this.categoryId = categoryId;
    }

    public Product(Integer id, String name, Double price, Integer quantity, String color, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.categoryId = categoryId;
    }

    public Product(String name, Double price, Integer quantity, String color, String describe, Integer categoryId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.describe = describe;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
