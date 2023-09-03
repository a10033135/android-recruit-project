package com.hahow.di

import com.hahow.repository.CourseRepository
import com.hahow.repository.RepositoryImpl
import com.hahow.repository.local.CourseLocalRepository
import com.hahow.useCase.GetCourseListUseCase
import com.hahow.repository.local.LocalRepositoryImpl
import com.hahow.repository.network.CourseNetworkRepository
import com.hahow.repository.network.NetworkRepositoryImpl
import com.hahow.views.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<CourseNetworkRepository> { NetworkRepositoryImpl(androidContext()) }
    factory<CourseLocalRepository> { LocalRepositoryImpl(androidContext()) }
    factory<CourseRepository> { RepositoryImpl(androidContext(), get(), get()) }
    factory { GetCourseListUseCase(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}