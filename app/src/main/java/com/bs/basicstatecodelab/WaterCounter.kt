package com.bs.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit,
    onClear: () -> Unit
) {

    Column(modifier.padding(16.dp)) {
        if (count > 0) {
            //Use remember to save the state, so that it won't reset on recomposition
            var showTask by remember { mutableStateOf(true) }
            //Use rememberSaveable to save the state when configuration changes
            var checkedState by rememberSaveable { mutableStateOf(false) }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?",
                    onClose = { showTask = false },
                    checkedState = checkedState,
                    onCheckChanged = { checkedState = !checkedState }
                )
            }
            Text(text = "You've had $count glasses.")
        }
        Row {
            Button(
                modifier = Modifier.padding(end = 8.dp),
                onClick = onIncrement,
                enabled = count < 10
            ) {
                Text("Add one")
            }
            Button(
                onClick = onClear,
                enabled = count > 0
            ) {
                Text("Clear water count")
            }
        }
    }
}