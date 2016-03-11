package com.example.midas.domain.interactor;

import com.example.midas.domain.executor.PostThread;
import com.example.midas.domain.repository.User_InterfaceRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Midas on 11/3/2559.
 */
public class GetUserList extends UseCase{
    private final User_InterfaceRepository userRepository;

    @Inject
    public GetUserList(User_InterfaceRepository userRepository,
                       PostThread postThread) {
        super(postThread);
        this.userRepository = userRepository;
    }

    @Override public Observable buildUseCaseObservable() {
        return this.userRepository.users();
    }
}
