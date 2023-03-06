package be.technobel.api.repository;

import be.technobel.api.models.entity.Request;
import be.technobel.api.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request,Long> {
    Optional<Request> findByUser(User user);
}
