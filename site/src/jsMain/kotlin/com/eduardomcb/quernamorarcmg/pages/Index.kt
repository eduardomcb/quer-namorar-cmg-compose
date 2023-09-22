package com.eduardomcb.quernamorarcmg.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.navigation.Link
import kotlinx.browser.document
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import kotlin.random.Random
import kotlin.random.nextInt

@Page
@Composable
fun HomePage() {
    var answerYes by remember { mutableStateOf(false) }
    var buttonPos by remember { mutableStateOf(Pair(0, 0)) }

    Box(
        modifier = Modifier
            .id("container")
            .fillMaxSize()
            .background(Colors.LemonChiffon),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .id("info")
                .fillMaxSize()
        ) {

            P(
                attrs = Modifier
                    .fontSize(14.px)
                    .padding(left = 8.px)
                    .color(Colors.OrangeRed)
                    .toAttrs()
            ) {
                Link("https://github.com/eduardomcb", "Meu Github")
            }

        }

        H4(
            attrs = Modifier
                .align(Alignment.Center)
                .fontSize(18.px)
                .margin(bottom = 100.px)
                .color(Colors.OrangeRed)
                .toAttrs()
        ) {
            Text("Aceita namorar comigo?")
        }

        Button(
            onClick = {
                answerYes = true
            },
            modifier = Modifier
                .id("buttonYes")
                .background(color = Colors.OrangeRed)
                .width(70.px)
                .height(30.px)
                .margin(right = 90.px, top = 0.px, bottom = 0.px, left = 0.px)
                .borderRadius(20.px)
        ) {
            P(
                attrs = Modifier
                    .color(Colors.White)
                    .fontSize(16.px)
                    .textAlign(TextAlign.Center)
                    .margin(0.px)
                    .padding(0.px)
                    .toAttrs()
            ) {
                Text("Sim")
            }
        }

        Button(
            onClick = {

            },
            modifier = Modifier
                .id("buttonNo")
                .background(color = Colors.OrangeRed)
                .width(70.px)
                .height(30.px)
                .margin(right = 0.px, top = 0.px, bottom = 0.px, left = 90.px)
                .borderRadius(20.px)
                .translate(buttonPos.first.px, buttonPos.second.px)
                .onMouseEnter {
                    val xo = (document.body!!.offsetWidth / 2)
                    val yo = (document.body!!.offsetHeight / 2)

                    val x = Random.nextInt(
                        -xo + document.getElementById("buttonNo")!!.clientWidth..xo - document.getElementById("buttonNo")!!.clientWidth
                    )
                    val y = Random.nextInt(
                        -yo + document.getElementById("buttonNo")!!.clientHeight..yo - document.getElementById("buttonNo")!!.clientHeight
                    )

                    buttonPos = Pair(x, y)
                }
        ) {
            P(
                attrs = Modifier
                    .color(Colors.White)
                    .fontSize(16.px)
                    .textAlign(TextAlign.Center)
                    .margin(0.px)
                    .padding(0.px)
                    .toAttrs()
            ) {
                Text("Não")
            }
        }

        if (answerYes) {
            H4(
                attrs = Modifier
                    .align(Alignment.Center)
                    .margin(top = 70.px)
                    .color(Colors.OrangeRed)
                    .toAttrs()
            ) {
                Text("Eu sabia que você não ia resistir!!")
            }
        }
    }
}
