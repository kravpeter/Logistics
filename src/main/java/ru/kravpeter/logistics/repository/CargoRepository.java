package ru.kravpeter.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kravpeter.logistics.entity.Cargo;

import java.util.List;
import java.util.Optional;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

    @Override
    List<Cargo> findAll();

    @Override
    Optional<Cargo> findById(Long aLong);
}
