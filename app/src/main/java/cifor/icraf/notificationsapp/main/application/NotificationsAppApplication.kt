package cifor.icraf.notificationsapp.main.application

import android.app.Application
import cifor.icraf.notificationsapp.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class NotificationsAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(tree = Timber.DebugTree())
        startKoin {
            androidContext(androidContext = applicationContext)
            modules(modules = listOf(
                // Add the modules here...
            ))
        }
    }
}