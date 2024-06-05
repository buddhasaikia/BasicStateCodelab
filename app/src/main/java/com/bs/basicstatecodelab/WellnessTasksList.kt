package com.bs.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    tasks: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckChanged: (Boolean, WellnessTask) -> Unit
) {
    LazyColumn {
        items(
            items = tasks,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                onClose = { onCloseTask(task) },
                modifier = modifier,
                checkedState = task.checked,
                onCheckChanged = { checked ->
                    onCheckChanged(checked, task)
                }
            )
        }
    }
}

