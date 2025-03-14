package com.example.demoprojet.db;

import com.example.demoprojet.dto.DBUserInfo;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;


@Service
@Profile("dev")
public class DBInteractorStub implements DBInteractor {
    private HashMap<Long, DBUserInfo> interactors = new HashMap<>();



    @Override
    public DBUserInfo getById(long id) {
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
            u.setId((long)(interactors.size()+1));
            interactors.put(u.getId(), u);
        }
        return u;
    }
}
