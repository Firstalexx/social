package ru.cavd.social.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.time.Instant;
import java.time.ZonedDateTime;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("id")
    private Long id = null;

    @NonNull
    @JsonProperty("authorUserId")
    private Long authorUserId;

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

    public Post(@NonNull Long authorUserId, @NonNull String header, @NonNull String text, @NonNull byte[] image) {
        this.authorUserId = authorUserId;
        this.header = header;
        this.text = text;
        this.image = image;
    }
}
