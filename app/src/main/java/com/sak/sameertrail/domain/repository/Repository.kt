package com.sak.sameertrail.domain.repository

import com.sak.sameertrail.data.models.response.DashboardResponse
import com.sak.sameertrail.data.models.response.Section
import com.sak.sameertrail.data.utils.Resource

interface Repository {
    suspend fun getData() : Resource<ArrayList<Section>>
}