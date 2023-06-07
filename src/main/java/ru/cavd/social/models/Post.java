package ru.cavd.social.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.ZonedDateTime;

import static jakarta.persistence.CascadeType.ALL;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("id")
    private Long id = null;

    //TODO: спросить
    //@NonNull
    //@JsonProperty("authorUserId")
//    @Transient
//    @JsonIgnore()
    @ManyToOne(fetch = FetchType.LAZY,cascade=ALL)
    @JoinColumn()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonProperty("authorUserId")
    private User authorUser;
   // private Long authorUserId;

//    @JsonProperty(value = "authorUserId")
//    private Long authorUserId;
    @JsonProperty("header")
    private String header = "";

    @NonNull
    @JsonProperty("text")
    private String text;

    @NonNull
    @JsonProperty("image")
    private byte[] image = new byte[0];

    @NonNull
    @JsonProperty("dateTime")
    private Instant dateTime = ZonedDateTime.now().toInstant();

//    public Post(@NonNull Long authorUserId, @NonNull String header, @NonNull String text, @NonNull byte[] image) {
//        this.authorUserId = authorUserId;
//        this.header = header;
//        this.text = text;
//        this.image = image;
//    }

//    public Post(@NonNull String header, @NonNull String text, @NonNull byte[] image) {
//        this.authorUser = authorUser;
//        this.header = header;
//        this.text = text;
//        this.image = image;
//    }
    public Post(@NonNull User authorUser, @NonNull String header, @NonNull String text, @NonNull byte[] image) {
        this.authorUser = authorUser;
        this.header = header;
        this.text = text;
        this.image = image;
    }
}
