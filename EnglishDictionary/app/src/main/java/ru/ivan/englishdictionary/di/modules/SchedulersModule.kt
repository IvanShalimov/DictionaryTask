package ru.ivan.englishdictionary.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.ivan.englishdictionary.di.modules.qualifier.IO
import ru.ivan.englishdictionary.di.modules.qualifier.UI
import javax.inject.Singleton

@Module
class SchedulersModule {

    @Provides
    @Singleton
    @IO
    fun getIOScheduller(): Scheduler = Schedulers.io()

    @Provides
    @Singleton
    @UI
    fun getUIScheduller(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}
