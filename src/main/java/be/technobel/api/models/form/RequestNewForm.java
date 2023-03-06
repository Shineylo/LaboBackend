package be.technobel.api.models.form;

import be.technobel.api.models.dto.RequestDTO;
import be.technobel.api.models.entity.Request;
import be.technobel.api.models.entity.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class RequestNewForm {

    private LocalDate date;

    private int time;

    private int duration;

    private String reason;

    private List<Long> equipmentsId;


}
