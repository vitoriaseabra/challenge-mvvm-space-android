package com.devpass.spaceapp.repository

import com.devpass.spaceapp.model.LaunchpadDetail

interface LaunchpadDetailRepository {
    suspend fun fetchLaunchpadDetails(id: String) : LaunchpadDetail
}
