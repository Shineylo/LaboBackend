package be.technobel.api.service.impl;

import be.technobel.api.models.dto.ClassroomDTO;
import be.technobel.api.repository.ClassroomRepository;
import be.technobel.api.service.ClassroomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public List<ClassroomDTO> getAll() {
        return classroomRepository.findAll().stream()
                .map( ClassroomDTO::toDto )
                .toList();
    }
}
