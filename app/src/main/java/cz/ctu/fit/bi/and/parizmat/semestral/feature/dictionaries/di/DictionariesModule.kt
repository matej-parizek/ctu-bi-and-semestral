package cz.ctu.fit.bi.and.parizmat.semestral.feature.dictionaries.di

import cz.ctu.fit.bi.and.parizmat.semestral.core.data.db.WalkingDogDatabase
import cz.ctu.fit.bi.and.parizmat.semestral.feature.dictionaries.data.DogRepository
import cz.ctu.fit.bi.and.parizmat.semestral.feature.dictionaries.data.DogRepositoryImp
import cz.ctu.fit.bi.and.parizmat.semestral.feature.dictionaries.data.api.DogApi
import cz.ctu.fit.bi.and.parizmat.semestral.feature.dictionaries.data.api.DogRemoteDataSource
import cz.ctu.fit.bi.and.parizmat.semestral.feature.dictionaries.data.local.DogLocalDataSource
import cz.ctu.fit.bi.and.parizmat.semestral.feature.dictionaries.data.local.DogLocalDataSourceImp
import cz.ctu.fit.bi.and.parizmat.semestral.feature.dictionaries.presentation.detail.DetailDogViewModel
import cz.ctu.fit.bi.and.parizmat.semestral.feature.dictionaries.presentation.list.DogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit

val dictionariesModule = module {
    single { get<Retrofit>().create(DogApi::class.java) }
    factoryOf(::DogRemoteDataSource)

    single { get<WalkingDogDatabase>().dogDao() }
    factory<DogLocalDataSource> { DogLocalDataSourceImp(dao = get()) }

    single<DogRepository> {
        DogRepositoryImp(
            dogRemoteDataSource = get(),
            dogLocalDataSource = get()
        )
    }
    viewModel { DogViewModel(repository = get(), savedStateHandle = get()) }
    viewModel{ DetailDogViewModel(repository = get(), savedStateHandle = get()) }
}