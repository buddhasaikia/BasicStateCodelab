package com.bs.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    var count by rememberSaveable { mutableIntStateOf(0) }

    Column {
        WaterCounter(
            modifier,
            count,
            onIncrement = { count++ },
            onClear = { count = 0 }
        )
        WellnessTaskList(
            tasks = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task) },
            onCheckChanged = { checked, task ->
                wellnessViewModel.onCheckChanged(checked, task)
            }
        )
    }
}