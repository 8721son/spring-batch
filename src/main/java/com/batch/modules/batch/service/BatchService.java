package com.batch.modules.batch.service;

import com.batch.modules.batch.domain.dto.response.BatchResultDTO;
import com.batch.modules.batch.domain.entity.BatchEntity;
import com.batch.modules.batch.repository.BatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final BatchRepository batchRepository;

    public List<BatchResultDTO> getList(){
        return batchRepository.findAll().stream().map(BatchEntity::toDTO).collect(Collectors.toList());
    }
}
