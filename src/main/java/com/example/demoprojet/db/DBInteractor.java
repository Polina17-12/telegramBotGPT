package com.example.demoprojet.db;

import com.example.demoprojet.dto.DBUserInfo;

public interface DBInteractor {
    public DBUserInfo getById (Long id);
    public DBUserInfo put(DBUserInfo u);
}
