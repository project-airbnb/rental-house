package com.PKHS.airbnb.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String link;

    @ManyToOne
    @JoinColumn(name = "rent_id")
    private PostRent post;

    public Image() {
    }

    public Image(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public Image(String name, String link, PostRent post) {
        this.name = name;
        this.link = link;
        this.post = post;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public PostRent getPost() {
        return post;
    }

    public void setPost(PostRent post) {
        this.post = post;
    }
}
