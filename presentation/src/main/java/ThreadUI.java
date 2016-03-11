import com.example.midas.domain.executor.PostThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Midas on 11/3/2559.
 */
@Singleton
public class ThreadUI implements PostThread {
    @Inject
    public ThreadUI() {}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
