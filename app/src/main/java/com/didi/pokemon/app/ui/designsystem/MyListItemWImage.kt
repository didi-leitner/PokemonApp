package com.didi.pokemon.app.ui.designsystem

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import java.util.Date

/*
Template for list item with image, title, subtitle, date, *fav button, and click listener
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyListItemWImage(modifier: Modifier, id: Int,
                     title: String? = null,
                     subtitle: String? = null,
                     timeAdded: Long? = null,
                     imagePath: String? = null,
                     navigateToDetail: (Int)-> Unit, ) {

    //ListItemW

    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            //.semantics { selected = isSelected }
            .clip(CardDefaults.shape)
            .combinedClickable(
                onClick = {
                    println("TESTT on Click")
                    navigateToDetail(id)
                          },
                onLongClick = { /*toggleSelection(product.id)*/ }
            )
            .clip(CardDefaults.shape),
        colors = CardDefaults.cardColors(
            containerColor = /*if (isSelected) MaterialTheme.colorScheme.primaryContainer
            else if (isOpened) MaterialTheme.colorScheme.secondaryContainer
            else */MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {

                /*val clickModifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { toggleSelection(upload.id) }
                AnimatedContent(targetState = isSelected, label = "avatar") { selected ->
                    if (selected) {
                        SelectedProfileImage(clickModifier)
                    } else {
                        ProfileImage(
                            upload.sender.avatar,
                            upload.sender.fullName,
                            clickModifier
                        )
                    }
                }*/

                imagePath?.let {
                    AsyncImage(modifier = modifier.fillMaxHeight().width(80.dp),
                        //.background(Color.Red),
                        //.clip(RoundedCornerShape(10.dp, 0.dp, 0.dp, 10.dp)),
                        contentScale = ContentScale.Crop,//.Fit,
                        //alignment = Alignment.CenterStart,

                        model = it,

                        //painter = painter,
                        contentDescription = null
                    )
                }

                Row(modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp).padding(start = 12.dp)) {

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center
                    ) {

                        title?.let {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.labelMedium
                            )
                        }


                        subtitle?.let {
                            Text(
                                text = subtitle,
                                style = MaterialTheme.typography.labelMedium
                            )
                        }


                        timeAdded?.let {
                            Text(
                                text = Date(timeAdded).toString(),//.createdAt,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.outline
                            )
                        }

                    }


                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surface)
                    ) {
                        Icon(
                            imageVector = Icons.Default.StarBorder,
                            contentDescription = "Favorite",
                            tint = MaterialTheme.colorScheme.outline
                        )
                    }
                }


            }

            /*Text(
                text = product.subject,
                style = MaterialTheme.typography.bodyLarge,
                color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer
                else MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
            )
            Text(
                text = product.body,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                overflow = TextOverflow.Ellipsis
            )*/
        }
    }
}