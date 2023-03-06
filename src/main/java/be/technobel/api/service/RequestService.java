package be.technobel.api.service;



import be.technobel.api.models.dto.RequestDTO;
import be.technobel.api.models.form.RequestNewForm;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface RequestService {
    List<RequestDTO> getAllSelf(Authentication auth);
    RequestDTO getOne(Long id);
    void insert(RequestNewForm form, Authentication auth);
    void delete(long id);
    List<RequestDTO> getAll();

    void refuse(long id);
}
