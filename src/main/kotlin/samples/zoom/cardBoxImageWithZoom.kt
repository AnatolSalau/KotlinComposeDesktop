package samples.zoom

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


@Composable
@Preview
fun listItemWithZoom(name: String, prof: String) {
    var defaultText by remember { mutableStateOf("Переключить график") }
    MaterialTheme {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp,
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { defaultText = "AfterClick" },
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                        Text(text = defaultText)
                    }
                }
            }
        }
    }
}


