package org.noob.design.service;

import org.noob.design.mapper.MemorandumMapper;
import org.noob.design.pojo.Memorandum;
import org.noob.design.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemorandumServiceImpl implements MemorandumService {
    @Autowired
    private MemorandumMapper memorandumMapper;
    @Override
    public void Insert(Memorandum memorandum) {
        memorandumMapper.insert(memorandum);
    }

    @Override
    public List<Memorandum> SelectAll(User user) {
        return memorandumMapper.getAllMemorandum(user);
    }

    @Override
    public void deleteById(Integer id) {
        memorandumMapper.deleteById(id) ;
    }
}
