package com.labs.lab2.entity.dto;

import com.labs.lab2.entity.Post;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<PostDTO> posts;
}
