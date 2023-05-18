package com.pranay.aPODNasaKMP.ui.componants

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem
import com.pranay.aPODNasaKMP.util.asyncimage.AsyncImage
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MediaItemComponent(
    mediaItem: APODPictureItem,
    modifier: Modifier = Modifier,
    height: Dp = 120.dp,
    backgroundImageUrl: String,
    placeHolderImage: Painter = painterResource("ic_baseline_image_24.xml"),
    imageSelectedState: Boolean = false,
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp),
        shape = RoundedCornerShape(5),
        border = if (imageSelectedState) BorderStroke(1.dp, Color.Yellow) else BorderStroke(
            0.dp,
            Color.Transparent
        ),
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            AsyncImage(
                imageUrl = backgroundImageUrl,
                loadingPlaceholder = {
                    Image(
                        painter = placeHolderImage,
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier.matchParentSize()
                    )
                },
                errorPlaceholder = {
                    Image(
                        painter = placeHolderImage,
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier.matchParentSize()
                    )
                },
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = mediaItem.title.orEmpty(),
                style = TextStyle.Default.copy(color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp, top = 4.dp)
            )
            Row(modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp)) {
                Text(
                    text = mediaItem.date.orEmpty(),
                    style = TextStyle.Default.copy(color = Color.White.copy(alpha = 0.6f), fontSize = 12.sp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                mediaItem.copyright?.let {
                    Text(
                        text = "©" + mediaItem.copyright,
                        style = TextStyle.Default.copy(color = Color.White.copy(alpha = 0.6f), fontSize = 12.sp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }
    }
}
