package org.noob.design.service;

import org.noob.design.pojo.Memorandum;
import org.noob.design.pojo.User;

import java.util.List;

public interface MemorandumService {
    void Insert(Memorandum memorandum);
    List<Memorandum> SelectAll(User user);

    void deleteById(Integer id);
}
