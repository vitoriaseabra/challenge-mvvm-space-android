package com.devpass.spaceapp.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.model.LaunchpadDetail
import com.devpass.spaceapp.repository.LaunchpadDetailRepository
import com.devpass.spaceapp.repository.LaunchpadDetailRepositoryImpl
import kotlinx.coroutines.launch

class LaunchpadDetailsViewModel(
    private val launchpadDetailRepository: LaunchpadDetailRepository = LaunchpadDetailRepositoryImpl()
) : ViewModel() {

    private val _launchpadDetailsData = MutableLiveData<LaunchpadDetailsUiState>()
    val launchpadDetailsData: LiveData<LaunchpadDetailsUiState> = _launchpadDetailsData

    fun loadLaunchpadDetails(id: String) {
        viewModelScope.launch {
            try {
                val launchpadDetail: LaunchpadDetail = launchpadDetailRepository.fetchLaunchpadDetails(id)
                _launchpadDetailsData.value = LaunchpadDetailsUiState(
                    data = launchpadDetail
                )
            } catch (exception: Exception){
                _launchpadDetailsData.value = LaunchpadDetailsUiState(
                    error = exception
                )
            }
        }
    }
}

class LaunchpadDetailsUiState(
    val data: LaunchpadDetail? = null,
    private val error: Exception? = null
) {
    val showError: Boolean
    get() = error != null
}
