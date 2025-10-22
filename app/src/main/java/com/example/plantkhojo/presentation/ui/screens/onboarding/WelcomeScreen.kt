package com.example.plantkhojo.presentation.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantkhojo.R
import com.example.plantkhojo.domain.model.OnboardingPage
import com.example.plantkhojo.domain.model.getList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun WelcomeScreen(onSkipClick: () -> Unit = {}) {
    val list = getList()
    val pagerState = rememberPagerState(pageCount = { list.size })
    val coroutineScope = rememberCoroutineScope()

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        // Top Slider Screen with image
        Box(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth()
        ){
            HorizontalPager(pagerState) {
                PagerScreen(list[it].title, list[it].image)
            }
        }

        // Bottom Title  with Pager indicator
        BottomTitle(
            list,
            pagerState,
            coroutineScope,
            onSkipClick
        ) {
            coroutineScope.launch {
                if (pagerState.currentPage < pagerState.pageCount - 1) {
                    pagerState.scrollToPage(pagerState.currentPage + 1)
                }
            }
        }
    }
}

@Composable
fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        repeat(pageCount) { index    ->
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(
                        color = colorResource(if (index == currentPage) R.color.aquaticMist else R.color.gray),
                        shape = CircleShape
                    )
            )
            if (index < pageCount - 1) {
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
    }
}

@Composable
fun PagerScreen(title: String = "Scan", image: Int = R.drawable.img_plant_onboarding) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.aquaticMist))
    ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Scanner Frame",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(50.dp)
            )
    }
}

@Composable
fun BottomTitle(
    list: List<OnboardingPage>,
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    onSkipClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color.White)){

        Spacer(modifier = Modifier.height(16.dp))

        PagerIndicator(
            pageCount = list.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier.padding(16.dp)
        )

        // To Show title
        Text(
            text = list[pagerState.currentPage].title,
            modifier = Modifier
                .height(100.dp)
                .padding(top = 20.dp, start = 40.dp, end = 40.dp),
            color = Color.Black,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            lineHeight = 40.sp
        )

        // Box to position Skip text at bottom right
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Skip",
                color = Color.Gray,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.clickable {
                       onSkipClick()
                }
            )

            Text(
                text = "Next",
                color = Color.Gray,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.clickable {
                    onNextClick()
                }
            )
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun OnboardingPageOnePreview() {
    PagerScreen()
}