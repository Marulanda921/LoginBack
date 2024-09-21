package Riwi.LoginUsers.Infraestructure.Adapter.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
    private String name;
    private String email;
    private int age;
}