package be.technobel.api.service;


import be.technobel.api.models.dto.ClassroomDTO;

import java.util.List;

public interface ClassroomService {

    List<ClassroomDTO> getAll();
}
