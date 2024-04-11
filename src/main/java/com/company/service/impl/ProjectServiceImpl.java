package com.company.service.impl;

import com.company.dto.ProjectDTO;
import com.company.dto.TaskDTO;
import com.company.dto.UserDTO;
import com.company.enums.Status;
import com.company.service.ProjectService;
import com.company.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    private final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO save(ProjectDTO user) {
        if (user.getStatus() == null) {
            user.setStatus(Status.OPEN);
        }
        return super.save(user, user.getProjectCode());
    }

    @Override
    public ProjectDTO findById(String s) {
        return super.findById(s);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String s) {
        super.deleteById(s);
    }

    @Override
    public void update(ProjectDTO object) {
        super.update(object.getProjectCode(),object);

    }

    @Override
    public void projectComplete(ProjectDTO projectDTO) {
        projectDTO.setStatus(Status.COMPLETED);
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
        List<ProjectDTO> projectDTOList =
                findAll().stream()
                        .filter(projectDTO -> projectDTO.getAssignedManager().equals(manager))
                        .map(projectDTO -> {
                            List<TaskDTO> taskDTOList = taskService.findTasksByManager(manager);

                            int completeTaskCounts= (int) taskDTOList.stream().filter(taskDTO -> taskDTO.getProject().equals(projectDTO) && taskDTO.getTaskStatus()==Status.COMPLETED).count();
                            int unfinishedTaskCounts=(int) taskDTOList.stream().filter(taskDTO -> taskDTO.getProject().equals(projectDTO) && taskDTO.getTaskStatus()!=Status.COMPLETED).count();

                            projectDTO.setCompleteTaskCounts(completeTaskCounts);
                            projectDTO.setUnfinishedTaskCounts(unfinishedTaskCounts);
                            return projectDTO;

                        })
                        .collect(Collectors.toList());




        return projectDTOList;
    }
}
