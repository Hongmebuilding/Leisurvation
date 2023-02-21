package com.lec.spring.service;


import com.lec.spring.domain.CompanyWrite;
import com.lec.spring.repository.CompanyWriteRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompanyService {
    private CompanyWriteRepository companyWriteRepository;

    @Autowired
    public CompanyService(SqlSession sqlSession) {
        companyWriteRepository = sqlSession.getMapper(CompanyWriteRepository.class);
    }

    public int companyWrite(CompanyWrite companyWrite) {
        return companyWriteRepository.save(companyWrite);
    }
}