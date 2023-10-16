/*******************************************************************************
 * Copyright TVL. 2023. All rights reserved.
 * Last modified by asifAhmed on 6/23/23, 11:32 AM
 ******************************************************************************/

/*******************************************************************************
 * Copyright TVL. 2023. All rights reserved.
 * Last modified by asifAhmed on 3/9/23, 3:46 PM
 */
package dev.asifddlks.bhaibhaiclinicApp.networkCommunication

import java.io.IOException

class NoConnectivityException : IOException() {
    // You can send any message whatever you want from here.
    override val message: String
        get() = "Please check your internet connection then try again."
    // You can send any message whatever you want from here.
}