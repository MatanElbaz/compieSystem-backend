package com.example.compieSystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ImageCard {
    @Id
    private Long id;
    private String imageUrl;
    private String artistName;
    private String imageName;
    private String description;

    @OneToMany(mappedBy = "imageCard", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ChatObj> chatObjs;


    public ImageCard() {
    }

    public ImageCard(long id, String imageUrl, String artistName, String imageName, String description, List<ChatObj> chatObjs) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.artistName = artistName;
        this.imageName = imageName;
        this.description = description;
        this.chatObjs = chatObjs;
    }

    public List<ChatObj> getChatObjs() {
        return chatObjs;
    }

    public void setChatObjs(List<ChatObj> chatObjs) {
        this.chatObjs = chatObjs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ImageCard{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", artistName='" + artistName + '\'' +
                ", imageName='" + imageName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
