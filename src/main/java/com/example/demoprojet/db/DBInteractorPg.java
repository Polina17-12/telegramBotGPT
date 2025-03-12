package com.example.demoprojet.db;

import com.example.demoprojet.dto.DBUserInfo;
import com.example.demoprojet.repo.UsersRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class DBInteractorPg implements DBInteractor {
    private final UsersRepo usersRepo;

    @Override
    public DBUserInfo getById(Long id) {
        var userId = usersRepo.findByUserIdInTg(id);
        if (userId.isEmpty())
            throw new RuntimeException("");
        return userId.get().ToDBUserInfo();
    }

    public DBInteractorPg(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public DBUserInfo put(DBUserInfo u) {
        if (u.getDateTime() == null)
            u.setDateTime(LocalDateTime.now(ZoneOffset.UTC));
        var userToInfo = u.toInfoUsers();
        usersRepo.save(userToInfo);
        u.setUsernameID(userToInfo.getUserIdInTg());
        return u;
    }
}
