package Riwi.LoginUsers.Infraestructure.Persistence.Helpers;

import Riwi.LoginUsers.Domain.Model.Role;
import Riwi.LoginUsers.Infraestructure.Persistence.Repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createRoleIfNotFound("USER");
        createRoleIfNotFound("ADMIN");
    }

    private void createRoleIfNotFound(String roleName) {
        if (roleRepository.findByName(roleName).isEmpty()) {
            Role role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
            System.out.println(roleName + " role created");
        } else {
            System.out.println(roleName + " role already exists");
        }
    }
}
