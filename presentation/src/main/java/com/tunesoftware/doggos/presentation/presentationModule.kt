package com.tunesoftware.doggos.presentation

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MainViewModel(get()) }

    viewModel { DetailViewModel(get()) }
}