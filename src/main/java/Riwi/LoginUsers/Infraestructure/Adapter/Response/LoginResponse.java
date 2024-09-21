package Riwi.LoginUsers.Infraestructure.Adapter.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String message;
    private String token;

    public LoginResponse(String message) {
        this.message = message;
        this.token = token;
    }

}
