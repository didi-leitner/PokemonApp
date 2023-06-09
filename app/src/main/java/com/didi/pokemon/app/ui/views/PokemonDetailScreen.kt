package com.didi.pokemon.app.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.didi.pokemon.app.ui.designsystem.DraggableCardHeaderImage
import com.didi.pokemon.app.ui.designsystem.ExpandableText
import com.didi.pokemon.app.ui.viewModel.PokemonDetailsViewModel
import com.didi.pokemon.app.ui.viewState.PokemonDetailViewState

/*@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun preview(){
    val fakeAlert = FakeWeatherAlertsRepository.fakeAlerts[0]
    val zones = listOf<Zone>(Zone("MZT675", true))
    AlertDetailsScreen(
        WeatherAlertDetail(fakeAlert.id, fakeAlert.startDateUTC, fakeAlert.endDateUTC,
            fakeAlert.sender, fakeAlert.desc, fakeAlert.severity, fakeAlert.certainty,
            fakeAlert.urgency, zones, fakeAlert.instruction)
    )
}*/

@Composable
fun PokemonDetailsRoute(viewModel: PokemonDetailsViewModel = hiltViewModel()) {

    val pokemonDetail by viewModel.viewState.collectAsStateWithLifecycle()
    PokemonDetailsScreen(pokemonDetail)

}


@Composable
fun PokemonDetailsScreen(viewState: PokemonDetailViewState) {

    viewState.let { alert ->
        Column {

            viewState.detail?.pictureUrl?.let {
                Row(
                    Modifier
                        .zIndex(100f)
                        .fillMaxWidth()
                ) {
                    //TODO maybe download smaller/bigger images based on screen-size
                    DraggableCardHeaderImage(it)
                }
            }



            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Column {


                    Spacer(modifier = Modifier.height(12.dp))


                    Text(
                        "${viewState.detail?.name}",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(12.dp))



                    //Text("Abilities: ", style = MaterialTheme.typography.bodyMedium)
                    for (az in alert.list) {
                        Row {
                            Column {
                                Text(text = az.first, style = MaterialTheme.typography.bodyLarge)
                                if (!az.second.isNullOrEmpty()) {
                                    ExpandableText("Description: ${az.second}")
                                    Spacer(modifier = Modifier.height(12.dp))
                                }
                            }

                        }
                        Spacer(modifier = Modifier.height(3.dp))


                    }
                    Spacer(modifier = Modifier.height(9.dp))


                }
            }
        }

    }
}




