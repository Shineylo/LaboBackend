package be.technobel.api.service.impl;

import be.technobel.api.exceptions.ResourceNotFoundException;
import be.technobel.api.models.dto.RequestDTO;
import be.technobel.api.models.entity.Request;
import be.technobel.api.models.form.RequestNewForm;
import be.technobel.api.repository.EquipmentRepository;
import be.technobel.api.repository.RequestRepository;
import be.technobel.api.repository.UserRepository;
import be.technobel.api.service.RequestService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final EquipmentRepository equipmentRepository;
    private final UserRepository userRepository;

    public RequestServiceImpl(RequestRepository requestRepository, EquipmentRepository equipmentRepository, UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.equipmentRepository = equipmentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<RequestDTO> getAllSelf(Authentication auth) {

        String username = (String) auth.getPrincipal();

        return requestRepository.findByUser((userRepository.findByLogin(username).orElseThrow())).stream()
                .map( RequestDTO::toDto )
                .toList();
    }

    @Override
    public RequestDTO getOne(Long id) {
        return requestRepository.findById(id)
                .map( RequestDTO::toDto )
                .orElseThrow(() -> new ResourceNotFoundException(Request.class,id));
    }


    @Override
    public void insert(RequestNewForm form, Authentication auth) {

        String username = (String) auth.getPrincipal();
        Request entity = new Request();

        entity.setTimeSlot(form.getDate().atTime(LocalTime.of(form.getTime(),00)));
        entity.setDuration(LocalTime.of(form.getDuration(),00));
        entity.setReason(form.getReason());
        entity.setUser(userRepository.findByLogin(username).orElseThrow());
        entity.setEquipments(
                new HashSet<>(equipmentRepository.findAllById(form.getEquipmentsId()))
        );
        requestRepository.save( entity );
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<RequestDTO> getAll() {
        return requestRepository.findAll().stream()
                .map( RequestDTO::toDto )
                .toList();
    }

    @Override
    public void refuse(long id) {
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Request.class,id));

        request.setRefuse("true");

        requestRepository.save(request);
    }

}
