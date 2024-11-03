package com.labs.lab4.entity.dto;
import com.labs.lab4.entity.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    String name;
    List<PostDTO> posts;
}
