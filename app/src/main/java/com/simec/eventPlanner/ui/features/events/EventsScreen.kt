import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.eventPlanner.ui.features.home.eventList.EachEventCard
import com.simec.eventPlanner.ui.model.EventType
import java.util.UUID
import androidx.compose.runtime.derivedStateOf


@Composable
fun EventsScreen(navController: NavHostController) {

    val eventList = remember {
        List(20) { index ->
            EventType(
                id = UUID.randomUUID().toString(),
                type = if (index % 2 == 0) "Wedding" else "Birthday",
                persons = (index + 1) * 5,
                date = "2025-11-${index + 1}",
                time = "10:00 AM",
                location = "Location $index, Dhaka",
                imageUrl = "https://via.placeholder.com/300x200.png"
            )
        }
    }

    var searchText by remember { mutableStateOf("") }

    val filteredEvents by remember(searchText) {
        derivedStateOf {
            if (searchText.isBlank()) {
                eventList
            } else {
                eventList.filter {
                    it.type.contains(searchText, true) ||
                            it.location.contains(searchText, true)
                }
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "All Events",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text("Search by type or location") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )

        LazyColumn(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            items(filteredEvents, key = { it.id }) { event ->
                EachEventCard(event)
                Divider(modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewEventsScreen() {
    EventsScreen(navController = NavHostController(LocalContext.current))
}
