package com.example.demoprojet.db;

import com.example.demoprojet.dto.DBUserInfo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;

@Component
public class DBInteractorStub implements DBInteractor {
    private HashMap<Long, DBUserInfo> interactors = new HashMap<>();



    @Override
    public DBUserInfo getById(Long id) {
        if (interactors.containsKey(id))
            return interactors.get(id);
        return null;
    }

    @Override
    public DBUserInfo put(DBUserInfo u) {
        if (u.getDateTime() == null)
            u.setDateTime(LocalDateTime.now(ZoneOffset.UTC));
        if (interactors.containsKey(u.getId())) {
            interactors.put(u.getId(), u);
        }
        else {
            u.setId(interactors.size()+1);
            interactors.put(u.getId(), u);
        }
        return u;
    }
}
