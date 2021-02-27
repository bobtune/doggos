package com.tunesoftware.doggos

import android.app.Application
import com.tunesoftware.doggos.data.dataModule
import com.tunesoftware.doggos.domain.domainModule
import com.tunesoftware.doggos.presentation.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DoggosApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DoggosApp)
            modules(
                listOf(dataModule, domainModule, presentationModule)
            )
        }
    }
}