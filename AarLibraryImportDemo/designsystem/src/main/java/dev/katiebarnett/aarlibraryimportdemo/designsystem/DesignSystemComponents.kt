package dev.katiebarnett.aarlibraryimportdemo.designsystem

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dev.katiebarnett.someaarlibrary.theme.MyCoolTheme


@Composable
fun buttonColors() = ButtonDefaults.buttonColors(
    containerColor = MyCoolTheme.ThemePrimaryColour,
    contentColor = Color.White
)

@Composable
fun SomeComponent(modifier: Modifier) {
    Column(modifier) {
        Text("I am some coloured text", color = MyCoolTheme.ThemePrimaryColour,)
        ThemedButton("Button!", onClick = {})
    }
}

@Composable
fun ThemedButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = buttonColors(),
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun SomeComponentPreview() {
    MaterialTheme {
        SomeComponent(Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun ThemedButtonPreview() {
    MaterialTheme {
        ThemedButton("Button!", onClick = {})
    }
}