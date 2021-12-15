package com.example.compieSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ChatObj {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "imageCard_id")
    @JsonIgnore
    private ImageCard imageCard;
    private String user;
    private String message;

    public ChatObj(Long id, ImageCard imageCard, String user, String message) {
        this.id = id;
        this.imageCard = imageCard;
        this.user = user;
        this.message = message;
    }

    public ChatObj() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageCard getImageCard() {
        return imageCard;
    }

    public void setImageCard(ImageCard imageCard) {
        this.imageCard = imageCard;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ChatObj{" +
                "id=" + id +
                ", imageCard=" + imageCard +
                ", user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
