package ru.kravpeter.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravpeter.logistics.entity.Checkpoint;
import ru.kravpeter.logistics.repository.CheckpointRepository;

@Service
public class CheckpointService {

    @Autowired
    CheckpointRepository checkpointRepository;

    public void save (Checkpoint checkpoint){checkpointRepository.save(checkpoint);}
}
