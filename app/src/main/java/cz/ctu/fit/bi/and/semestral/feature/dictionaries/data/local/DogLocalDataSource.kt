package cz.ctu.fit.bi.and.semestral.feature.dictionaries.data.local

import cz.ctu.fit.bi.and.semestral.feature.dictionaries.domain.Dog
import kotlinx.coroutines.flow.Flow

interface DogLocalDataSource {
    suspend fun upsertAll(data: List<Dog>)
    fun getDogsStream(): Flow<List<Dog>>
}