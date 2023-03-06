package be.technobel.api.controller;

import be.technobel.api.models.dto.ClassroomDTO;
import be.technobel.api.service.ClassroomService;
import be.technobel.api.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService, EquipmentService equipmentService) {
        this.classroomService = classroomService;
    }

    //GET - /classroom
    @GetMapping("/all")
    public List<ClassroomDTO> getAll(){
        return classroomService.getAll();
    }
}
