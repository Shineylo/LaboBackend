package be.technobel.api.models.dto;

import be.technobel.api.models.entity.Classroom;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class ClassroomDTO {
    private Long id;

    private int capacity;

    private String name;

    private boolean teacherOnly;

    private Set<RequestDTO> request;

    private Set<EquipmentDTO> equipments;

    public static ClassroomDTO toDto(Classroom entity) {
        if( entity == null )
            return null;

        return ClassroomDTO.builder()
                .id( entity.getId() )
                .capacity(entity.getCapacity())
                .name( entity.getName() )
                .teacherOnly(entity.isTeacherOnly())
                .equipments(
                        entity.getEquipments().stream()
                                .map(EquipmentDTO::toDto)
                                .collect(Collectors.toSet())
                )
                .build();
    }
}
