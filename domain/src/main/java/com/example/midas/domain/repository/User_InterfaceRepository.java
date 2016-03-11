package com.example.midas.domain.repository;

import com.example.midas.domain.User;

import java.util.List;

import rx.Observable;

/**
 * Created by Midas on 11/3/2559.
 */
public interface User_InterfaceRepository {
    Observable<List<User>> users();
}
