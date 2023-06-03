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

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("id")
    private Long id = null;

    @NonNull
    @JsonProperty("userName")
    private String userName;

    @NonNull
    @JsonProperty("eMail")
    private String eMail;

    @NonNull
    @JsonProperty(access = READ_ONLY, namespace = "password")
    private String password;

    @NonNull
    @JsonProperty("isConfirmed")
    private Boolean isConfirmed = false;


}