package ru.kravpeter.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kravpeter.logistics.entity.Checkpoint;

import java.util.List;
import java.util.Optional;

public interface CheckpointRepository extends JpaRepository<Checkpoint, Long> {
    @Override
    List<Checkpoint> findAll();

    @Override
    Optional<Checkpoint> findById(Long checkpointId);
}
