package com.example.presentation.on_boarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.RSTheme
import kotlinx.coroutines.delay


@Composable
fun PagerSlide(modifier: Modifier = Modifier) {

    val pagerState = rememberPagerState(pageCount = {
        content.size
    })

    Column(
        modifier = modifier
            .padding(top = 40.dp)
            .fillMaxWidth()
    ) {

        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fill,
        ) { page ->
            SingleSlide(content[page])
        }

        val isDraggedState = pagerState.interactionSource.collectIsDraggedAsState()

        LaunchedEffect(isDraggedState) {
            while (true) {
                delay(2000L)
                runCatching {
                    pagerState.animateScrollToPage(pagerState.currentPage.inc() % pagerState.pageCount)
                }
            }
        }

        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(top = 40.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val isActive = pagerState.currentPage == iteration
                Box(
                    modifier = Modifier
                        .padding(if (isActive) 4.5.dp else 2.5.dp)
                        .clip(RectangleShape)
                        .background(
                            if (isActive) RSTheme.colors.textColorPrimary else RSTheme.colors.textColorMain,
                            shape = RoundedCornerShape(11.dp)
                        )
                        .align(Alignment.CenterVertically)
                        .width(if (isActive) 37.dp else 15.dp)
                        .height(6.dp)
                )
            }
        }
    }
}

@Composable
fun SingleSlide(page: PagerContent) {
    Column(
        Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = page.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(horizontal = 35.5.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(143.dp)
                .clip(RoundedCornerShape(16.dp))

        )

        Text(
            text = stringResource(id = page.title),
            style = RSTheme.typography.bold20,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp, top = 32.dp),
            color = RSTheme.colors.textColorMain

        )

        Text(
            text = stringResource(id = page.description),
            style = RSTheme.typography.regular14,
            modifier = Modifier
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center,
            color = RSTheme.colors.textColorMain
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PagerSlidePreview() {
    PagerSlide()
}
