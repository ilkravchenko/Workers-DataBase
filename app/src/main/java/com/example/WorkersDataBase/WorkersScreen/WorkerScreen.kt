package com.example.WorkersDataBase.WorkersScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.WorkersDataBase.AddWorker.AddRabotnikDialog
import com.example.WorkersDataBase.RabotnikEvent
import com.example.WorkersDataBase.RabotnikState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RabotnikScreen(
    state: RabotnikState,
    onEvent: (RabotnikEvent) -> Unit
) {

    Scaffold (
        floatingActionButton ={
            FloatingActionButton(onClick = { onEvent(RabotnikEvent.ShowDialog) }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription ="add employee"
                )
            }

        }
    ){padding ->
        if(state.isAddingRabotnik){
            AddRabotnikDialog(state = state, onEvent = onEvent )
        }
        LazyColumn(
            contentPadding =padding,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp),

        ){
            item{
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .clip(RoundedCornerShape(32.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                }
            }
            items(state.worker){ rabotnik ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer),
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(8.dp),
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            text = "${rabotnik.name}",
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            text = "Position: ${rabotnik.position}",
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            text = "Total: ${rabotnik.zarplata}",
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    IconButton(
                        onClick = {
                            onEvent(RabotnikEvent.DeleteRabotnik(rabotnik))
                        },
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Contact")
                    }
                }
            }
        }
    }
}





