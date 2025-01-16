package com.example.designsystem.components.policy

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.RSTheme
import com.example.ratatouille.R

@Composable
fun PrivacyPolicyScreen(
    popBackStack: () -> Unit,
) {
    PrivacyPolicyContent { popBackStack.invoke() }
}

@Composable
fun PrivacyPolicyContent(
    popBackStack: () -> Unit,
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(color = RSTheme.colors.bgColorMain)
            .padding(horizontal = 16.dp)
            .padding(bottom = 40.dp)
            .padding(top = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .background(color = RSTheme.colors.bgColorMain),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .clickable(true) {
                        popBackStack.invoke()
                    },
                painter = painterResource(id = RSTheme.icons.icBackArrow),
                contentDescription = null,
                tint = RSTheme.colors.textColorMain
            )
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.privacy_policy_header),
                    color = RSTheme.colors.textColorMain,
                    style = RSTheme.typography.bold16
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
        ) {

            Text(
                modifier = Modifier.padding(top = 40.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.introduction),
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.bold16
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Start,
                text = stringResource(id = R.string.introduction_desc),
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.regular14
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.information_we_collect),
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.bold16
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Start,
                text = stringResource(id = R.string.information_we_collect_part_1),
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.regular16
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Start,
                text = stringResource(id = R.string.information_we_collect_part_2),
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.regular16
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.how_we_use),
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.bold16
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Start,
                text = stringResource(id = R.string.how_we_use_desc),
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.regular16
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.how_we_share),
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.bold16
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Start,
                text = stringResource(id = R.string.how_we_share_1),
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.regular16
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Start,
                text = stringResource(id = R.string.how_we_share_2),
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.regular16
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrivacyPolicyPreview() {
    PrivacyPolicyContent(
        {}
    )
}
