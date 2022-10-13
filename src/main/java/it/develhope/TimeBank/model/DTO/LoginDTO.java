package it.develhope.TimeBank.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    /** This is the user email*/
    private String email;
    /** This is the user password*/
    private String password;

}
