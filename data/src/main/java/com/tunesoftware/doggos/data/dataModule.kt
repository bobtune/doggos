package com.tunesoftware.doggos.data

import com.tunesoftware.doggos.domain.Breed
import com.tunesoftware.doggos.domain.BreedDetail
import com.tunesoftware.doggos.domain.DogRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {

    single { createGson() }

    single { createGsonConverter(get()) }

    single { createOkHttpClient() }

    single<DogApi> { createRetrofit(get(), get(), BuildConfig.API_URL) }

    single<Mapper<BreedDto, Breed>>(named("breed_map")) { BreedMapper() }

    single<Mapper<String, BreedDetail.SizePair>>(named("dim_map")) { DimensionMapper() }

    single<Mapper<BreedDetailDto, BreedDetail>>(named("detail_map")) { BreedDetailMapper(get(named("dim_map"))) }

    single<DogRepository> { DogRepositoryImpl(get(), get(named("breed_map")), get(named("detail_map"))) }
}