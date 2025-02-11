package com.professional.backend.infrastructure.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.professional.backend.infrastructure.data.model.entity.UserFile;

import java.util.Optional;


public interface UserFileRepository extends CrudRepository<UserFile, Long> {
    public Optional<UserFile> findByChecksum(String checksum);
    public void deleteByChecksum(String checksum);
    public boolean existsByChecksum(String checksum);
    public boolean existsById(Long id);
}
