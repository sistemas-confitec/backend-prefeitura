package com.app.prefeitura.dto;

/**
 *
 * @author Robson
 */
public class FotoDTO {
    
    private String name;
    private Integer height;
    private Integer width;
    private String base64;

    public FotoDTO() {
    }

    public FotoDTO(String name, Integer height, Integer width, String base64) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.base64 = base64;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
    
    
}
