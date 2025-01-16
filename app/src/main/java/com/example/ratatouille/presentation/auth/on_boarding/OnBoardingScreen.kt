package com.example.presentation.on_boarding

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.components.DefaultButton
import com.example.designsystem.components.MyOutlinedButton
import com.example.designsystem.theme.RSTheme
import com.example.ratatouille.R
import com.example.ratatouille.domain.model.Language
import kotlinx.coroutines.CoroutineScope


val content = listOf(
    PagerContent(
        R.drawable.ratatouille,
        R.string.benefits,
        R.string.benefits_desc
    ),
    PagerContent(
        R.drawable.slider22,
        R.string.benefits,
        R.string.benefits_desc
    ),
    PagerContent(
        R.drawable.ratatouille,
        R.string.benefits,
        R.string.benefits_desc
    ),
)

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun OnBoardingScreen(
    viewmodel: OnBoardingViewmodel = hiltViewModel(),
) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val onBoardingState by viewmodel.onBoardingState.collectAsStateWithLifecycle()

    LaunchedEffect(onBoardingState.currentLanguage) {
        Log.d("language", "launch")
    }

    OnBoardingScreenContent(
        Modifier,
        context,
        coroutineScope,
        onEvent = { event -> viewmodel.handleEvents(event) },
        onBoardingState
    )
}

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OnBoardingScreenContent(
    modifier: Modifier = Modifier,
    context: Context,
    coroutineScope: CoroutineScope,
    onEvent: (OnBoardingEvent) -> Unit,
    onBoardingState: OnBoardingState,
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = RSTheme.colors.bgColorMain)
            .verticalScroll(scrollState),
//        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(36.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = RSTheme.icons.icLogo),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .clickable(true) {
                        Log.d(
                            "language",
                            "cur ${onBoardingState.currentLanguage} oppo ${
                                Language.getOppositeLanguage(onBoardingState.currentLanguage)!!.configName
                            }"
                        )
                        onEvent.invoke(
                            OnBoardingEvent.ChangeLanguage(
                                context,
                                Language.getOppositeLanguage(onBoardingState.currentLanguage)!!.configName
                            )
                        )

                    }
                    .border(
                        width = 1.dp,
                        color = RSTheme.colors.borderGrey,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(vertical = 6.dp, horizontal = 13.5.dp),
            ) {
                Image(
                    painter = painterResource(id = RSTheme.icons.icGlobe),
                    contentDescription = "",
                    Modifier.padding(end = 4.dp)
                )

                Text(
                    text = stringResource(id = R.string.language),
                    style = RSTheme.typography.regular14,
                    color = RSTheme.colors.borderGrey
                )
            }
        }

        PagerSlide(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        DefaultButton(
            text = stringResource(id = R.string.welcome_back),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
            onClick = {
                onEvent.invoke(OnBoardingEvent.NavigateToHome)
            }
        )
//        MyOutlinedButton(
//            text = stringResource(id = R.string.sign_me),
//            modifier = Modifier.padding(horizontal = 16.dp),
//            onClick = {
//                onEvent.invoke(OnBoardingEvent.NavigateToSignUp)
//            }
//        )

        FlowRow(
            modifier = Modifier
                .padding(top = 20.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.agree),
                style = RSTheme.typography.medium12,
                color = RSTheme.colors.textColorMain
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                modifier = Modifier.clickable {
                    onEvent.invoke(OnBoardingEvent.PolicyClick)
                },
                text = stringResource(id = R.string.privacy_policy),
                style = RSTheme.typography.bold12,
                color = RSTheme.colors.textColorMain
            )
        }
    }
}

@Composable
fun DividerWithText(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = RSTheme.colors.textColorAdditional,
            thickness = 1.dp
        )
        Spacer(modifier = Modifier.width(8.dp)) // Add space between the divider and text
        Text(
            text = text,
            style = RSTheme.typography.regular12,
            color = RSTheme.colors.textColorAdditional
        )
        Spacer(modifier = Modifier.width(8.dp)) // Add space between the text and divider
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = RSTheme.colors.textColorAdditional,
            thickness = 1.dp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    OnBoardingScreen()
}