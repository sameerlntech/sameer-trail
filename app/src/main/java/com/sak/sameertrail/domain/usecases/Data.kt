package com.sak.sameertrail.domain.usecases

import android.annotation.SuppressLint
import com.sak.sameertrail.data.datasource.repository.RepositoryImp
import com.sak.sameertrail.data.models.response.Section
import com.sak.sameertrail.data.utils.Resource
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.android.scopes.ViewScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class Data @Inject constructor(
    private val repositoryImp: RepositoryImp
) {

    fun getData() : Flow<Resource<ArrayList<Section>>> = flow {
           emit(Resource.Loading())
        try {
         val response  = repositoryImp.getData()
            emit(Resource.Success(response.data!!))
        } catch (e : HttpException){
            emit(Resource.Error("${e.localizedMessage.toString()}"))
        } catch (e : IOException){
            emit(Resource.Error("${e.localizedMessage.toString()}"))
        }
    }

}