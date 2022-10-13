package it.develhope.TimeBank.model.DTO;

import it.develhope.TimeBank.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRTO {

    private User user;
    private String JWT;
}
