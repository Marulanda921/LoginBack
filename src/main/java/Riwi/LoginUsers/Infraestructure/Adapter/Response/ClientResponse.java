package Riwi.LoginUsers.Infraestructure.Adapter.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    private int id;
    private String name;
    private String email;
    private int age;
}