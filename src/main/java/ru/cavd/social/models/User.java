package ru.cavd.social.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {

    @JsonProperty("id")
    private Long id = null;

    @NonNull
    @JsonProperty("userName")
    private String userName;

    @NonNull
    @JsonProperty("eMail")
    private String eMail;

    @NonNull
    @JsonProperty("password")
    private String password;

    @NonNull
    @JsonProperty("isConfirmed")
    private Boolean isConfirmed = false;

}