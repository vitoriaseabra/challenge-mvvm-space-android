package com.devpass.spaceapp.repository

import com.devpass.spaceapp.data.api.NetworkService
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.mapper.toModel
import com.devpass.spaceapp.model.LaunchpadDetail

class LaunchpadDetailRepositoryImpl(
    val api: SpaceXAPIService = NetworkService.getSpaceXAPI()
) : LaunchpadDetailRepository {
    override suspend fun fetchLaunchpadDetails(id: String): LaunchpadDetail {
        return api.fetchLaunchpadDetails(id).toModel()
    }
}
