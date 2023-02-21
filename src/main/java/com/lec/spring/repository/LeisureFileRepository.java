package com.lec.spring.repository;

import com.lec.spring.domain.LeisureFileDTO;

import java.util.List;
import java.util.Map;

public interface LeisureFileRepository {

    int insert(List<Map<String, Object>> list, Long writeId);

    int save(LeisureFileDTO file);

    List<LeisureFileDTO> findByWrite(Long writeId);

    LeisureFileDTO findById(Long id);

    List<LeisureFileDTO> findByIds(Long [] ids);

    int deleteByids(Long [] ids);

    int delete(LeisureFileDTO file);
}

