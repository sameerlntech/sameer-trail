package com.sak.sameertrail.presentation.ui.dashboard

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sak.sameertrail.data.models.response.Section
import com.sak.sameertrail.data.utils.Resource
import com.sak.sameertrail.domain.usecases.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val data: Data
) :ViewModel(){

    val success : MutableLiveData<ArrayList<Section>> = MutableLiveData()
    val error : MutableLiveData<String> = MutableLiveData()
    val loading : MutableLiveData<String> = MutableLiveData()


    fun getData(){

        data.getData().onEach { result ->

            when(result){
                is Resource.Loading -> {
                    loading.postValue("Loading ...")
                }
                is Resource.Success -> {
                    if(result.data != null) success.postValue(result.data!!)
                    Log.d("Data->",result.data.toString())
                }
                is Resource.Error -> {
                    error.postValue("Please make sure your internet is stable")
                }
            }

        }.launchIn(viewModelScope)

    }



}