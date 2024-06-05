package com.bs.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private var _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask> = _tasks

    private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

    fun onCheckChanged(checked: Boolean, wellnessTask: WellnessTask) {
        _tasks.find { it.id == wellnessTask.id }?.let { task ->
            task.checked = checked
        }
    }

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

}