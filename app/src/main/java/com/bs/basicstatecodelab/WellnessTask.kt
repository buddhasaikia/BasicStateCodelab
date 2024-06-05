package com.bs.basicstatecodelab

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {
    //Since we need to update the UI when the value of the property "checked" changes,
    //it need to be a MutableState otherwise Compose will not update the UI.
    //Use delegation by using "by" keyword so that you don't need to use .value to set/get the value.
    //Use of delegation is not possible in data class
    var checked by mutableStateOf(initialChecked)
}