package com.company.bootstrap;

import com.company.dto.ProjectDTO;
import com.company.dto.RoleDTO;
import com.company.dto.UserDTO;
import com.company.enums.Gender;
import com.company.enums.Status;
import com.company.service.ProjectService;
import com.company.service.RoleService;
import com.company.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;

    private final ProjectService projectService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John", "Doe", "johndoe", "password123", true, "123-456-7890", adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Alice", "Smith", "asmith", "abc@123", true, "987-654-3210", managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Michael", "Johnson", "mjohnson", "pass1234", true, "555-123-4567", employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);

        ProjectDTO projectDTO1 = new ProjectDTO("software upgrade", "SW001", user2, LocalDate.now(), LocalDate.now().plusDays(14L),"Let's go team", Status.OPEN);
        projectService.save(projectDTO1);
    }
}
