package ru.vlasov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlasov.entity.RecordEntity;
import ru.vlasov.entity.UserEntity;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllById(String name);

    List<UserEntity> findAllByNameContains(String part);
}