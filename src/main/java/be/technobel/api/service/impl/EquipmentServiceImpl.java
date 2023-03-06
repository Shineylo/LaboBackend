package be.technobel.api.service.impl;

import be.technobel.api.models.dto.EquipmentDTO;
import be.technobel.api.repository.EquipmentRepository;
import be.technobel.api.service.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<EquipmentDTO> getAll() {
        return equipmentRepository.findAll().stream()
                .map( EquipmentDTO::toDto )
                .toList();
    }
}
