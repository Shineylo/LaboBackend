package be.technobel.api.controller;

import be.technobel.api.models.dto.RequestDTO;
import be.technobel.api.models.form.RequestNewForm;
import be.technobel.api.service.RequestService;
import be.technobel.api.service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    private final RequestService requestService;
    private final EquipmentService equipmentService;

    public RequestController(RequestService requestService, EquipmentService equipmentService) {
        this.requestService = requestService;
        this.equipmentService = equipmentService;
    }

    //GET - /request/all
    @GetMapping("/mine")
    public List<RequestDTO> getAllSelf(Authentication auth){
        return requestService.getAllSelf(auth);
    }

    @GetMapping("/all")
    public List<RequestDTO> getAll(){
        return requestService.getAll();
    }

    //POST - /request/add
    @PostMapping("/add")
    public void processInsertForm(@RequestBody @Valid RequestNewForm form,Authentication auth){
        requestService.insert(form, auth);
    }

    //POST - /request/add
    @DeleteMapping ("/{id:[0-9]+}/delete")
    public void delete(@PathVariable long id){
        requestService.delete(id);
    }

    @PatchMapping("/{id:[0-9]+}/refuse")
    public void refuse(@PathVariable long id){
        requestService.refuse(id);
    }

    //@GetMapping Mapping("/{id:[0-9]+}/manage")


}
