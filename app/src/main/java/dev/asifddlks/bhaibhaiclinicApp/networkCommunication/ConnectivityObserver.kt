/*******************************************************************************
 * Copyright TVL. 2023. All rights reserved.
 * Last modified by asifAhmed on 6/23/23, 11:32 AM
 ******************************************************************************/

package dev.asifddlks.bhaibhaiclinicApp.networkCommunication

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    fun observe(): Flow<Status>

    enum class Status {
        Available, Unavailable, Losing, Lost
    }
}