package com.professional.bot.service;

import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.professional.bot.data.entity.ReaderCache;
import com.professional.bot.data.repository.ReaderCacheRepository;

import jakarta.transaction.NotSupportedException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@Service
public class ReaderCacheService {

    @Autowired
    private ReaderCacheRepository readerCacheRepository;

    @Transactional
    public void saveReaderCache(ReaderCache cache) {
        readerCacheRepository.save(cache);
    }

    public ReaderCache getReaderCache(Long telegramId) throws IllegalStateException {
        Optional<ReaderCache> readerCacheQuery = readerCacheRepository.findById(telegramId);
        if (readerCacheQuery.isPresent() == false) {
            throw new IllegalStateException();
        }
        return readerCacheQuery.get();
    }

    public boolean isReaderDataCached(Long telegramId) {
        try {
            this.getReaderCache(telegramId);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }
    public void clearReaderCache(Long telegramId) {
        try{
            ReaderCache cache = this.getReaderCache(telegramId);
            readerCacheRepository.delete(cache);
        } catch (IllegalStateException e) {
            throw new NotFoundException("The user's cache not found");
        }
        
    }
}
