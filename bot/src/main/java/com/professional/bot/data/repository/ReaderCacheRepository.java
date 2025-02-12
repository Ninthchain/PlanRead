package com.professional.bot.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.professional.bot.data.entity.ReaderCache;
import java.util.List;


public interface ReaderCacheRepository extends CrudRepository<ReaderCache, Long> {
    List<ReaderCache> findByDialogStatus(short dialogStatus);
    
}
