package com.professional.backend.infrastructure.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.professional.backend.infrastructure.data.model.entity.UserFile;
import com.professional.backend.infrastructure.data.repository.UserFileRepository;
import com.professional.backend.utils.UserFileProcessor;

import jakarta.transaction.Transactional;

@Service
public class StorageService {
    @Autowired
    private UserFileRepository userFileRepository;

    public UserFile getFile(Long fileId) throws IllegalStateException {

        Optional<UserFile> findFileQueryResult = userFileRepository.findById(fileId);
        if (!findFileQueryResult.isPresent()) {

            throw new IllegalStateException(String.format("The file with %d id has not been found", fileId));
        }
        return findFileQueryResult.get();
    }

    public UserFile getFile(String checksum) throws IllegalStateException {
        
        if (!userFileRepository.existsByChecksum(checksum)) {
            // FIXME: Exception message is not written
            throw new IllegalStateException();
        }
        UserFile file = userFileRepository.findByChecksum(checksum).get();
        return file;
        
    }

    @Transactional
    public void uploadFile(MultipartFile entryFile) throws IOException, NoSuchAlgorithmException {
        UserFile file = new UserFile();

        file.setExtensionName(UserFileProcessor.getExtensionName(entryFile.getName()));
        file.setName(UserFileProcessor.getFileNameWithoutExtension(entryFile.getName()));
        file.setContent(entryFile.getBytes());
        file.setChecksum(UserFileProcessor.getFileChecksum(entryFile.getBytes()));
        userFileRepository.save(file);
    }

  

    @Transactional
    public void deleteFile(Long fileId) throws IllegalStateException{
        if(!userFileRepository.existsById(fileId)) {
            // TODO: write error msg
            throw new IllegalStateException();
        }
        userFileRepository.deleteById(fileId);
    }

    @Transactional
    public void deleteFile(String checksum) {
        if(!userFileRepository.existsByChecksum(checksum)) {
            // TODO: write error msg
            throw new IllegalStateException();
        }
        userFileRepository.deleteByChecksum(checksum);
    }
}
