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

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static jakarta.persistence.CascadeType.ALL;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "Users")
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
    @JsonProperty( value="password",access = WRITE_ONLY)
    private String password;

    @NonNull
    @JsonProperty("isConfirmed")
    private Boolean isConfirmed = false;

    @Transient
    @JsonIgnore
    @OneToMany(cascade=ALL, mappedBy="Users",fetch = FetchType.LAZY)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn()
    List<Post> posts;

    public User(Long id) {
        this.id = id;
    }
}