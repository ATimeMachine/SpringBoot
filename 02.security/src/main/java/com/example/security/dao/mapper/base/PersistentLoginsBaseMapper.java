package com.example.security.dao.mapper.base;

import com.example.security.dao.model.PersistentLogins;

import java.util.List;
/**
*  @author persistentLogins
*/
public interface PersistentLoginsBaseMapper {

    int insertPersistentLogins(PersistentLogins object);

    int updatePersistentLogins(PersistentLogins object);

    int update(PersistentLogins.UpdateBuilder object);

    List<PersistentLogins> queryPersistentLogins(PersistentLogins object);

    PersistentLogins queryPersistentLoginsLimit1(PersistentLogins object);

}