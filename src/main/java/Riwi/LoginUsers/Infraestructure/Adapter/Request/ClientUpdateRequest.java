package Riwi.LoginUsers.Infraestructure.Adapter.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientUpdateRequest {
    private String name;
    private String email;
    private Integer age;
}
