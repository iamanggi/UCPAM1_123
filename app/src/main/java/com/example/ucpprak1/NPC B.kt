package com.example.ucpprak1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun Header(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.padding(10.dp).padding(top = 8.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                    Icon(Icons.Outlined.Notifications, contentDescription = null)
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Column{
                            Text(text = "Good Afternoon,", style = TextStyle(fontSize = 14.sp))
                            Text(
                                text = "Anggi Puspita",
                                style = TextStyle(fontSize = 20.sp),
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(vertical = 5.dp)
                            )
                        }

                    }

                }

            }

        }

        var asal by remember { mutableStateOf("") }
        var tujuan by remember { mutableStateOf("") }
        var tglbrngkt by remember { mutableStateOf("") }
        var tgldatang by remember { mutableStateOf("") }
        var kelas by remember { mutableStateOf("") }

        var dataKelas = listOf("Ekonomi", "Bussiness")

        var confAsal by remember { mutableStateOf("") }
        var confTujuan by remember { mutableStateOf("") }
        var confTglbrngkt by remember { mutableStateOf("") }
        var confTgldatang by remember { mutableStateOf("") }
        var confKelas by remember { mutableStateOf("") }

        Box(
            modifier = Modifier.padding(horizontal = 5.dp).background(
                color = Color.Black,
                shape = RoundedCornerShape(size = 25.dp)
            ), contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = "Pemesanan",
                style = TextStyle(fontSize = 20.sp),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(5.dp)
            )
            Box(
                modifier = Modifier.padding(vertical = 35.dp, horizontal = 20.dp)
                    .background(color = Color.LightGray, shape = RoundedCornerShape(size = 20.dp))
            ) {

                Column (modifier = Modifier.padding(20.dp)){
                    TextField(
                        value = asal,
                        onValueChange = { asal = it },
                        label = {
                            Text(text = "Keberangkatan")
                        },
                        placeholder = {
                            Text(text = "tulis stasiun awal anda")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    TextField(
                        value = tujuan,
                        onValueChange = { tujuan = it },
                        label = {
                            Text(text = "Kota Tujuan")
                        },
                        placeholder = {
                            Text(text = "tulis stasiun awal anda")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row {
                        TextField(
                            value = tglbrngkt,
                            onValueChange = { tglbrngkt = it },
                            label = {
                                Text(
                                    text = "Tgl berangkat"
                                )
                            },
                            placeholder = {
                                Text(text = "Tanggal Keberangkatan anda")
                            },
                            modifier = Modifier.weight(1f)

                        )


                        TextField(
                            value = tgldatang,
                            onValueChange = { tgldatang = it },
                            label = {
                                Text(text = "Tgl datang")
                            },
                            placeholder = {
                                Text(text = "Tanggal kedatangan anda")
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Column(modifier = Modifier.padding(vertical = 5.dp)) {
                        Text(text = "Class")
                        Row(modifier = Modifier.fillMaxWidth()) {
                            dataKelas.forEach { selectedGender ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = kelas == selectedGender,
                                        onClick = {
                                            kelas = selectedGender
                                        }
                                    )
                                    Text(text = selectedGender)

                                }
                            }
                        }
                    }

                    Button(
                        modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                            .padding(10.dp), onClick = {
                            confAsal = asal
                            confTujuan = tujuan
                            confTglbrngkt = tglbrngkt
                            confTgldatang = tgldatang
                            confKelas = kelas
                        }, colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text(
                            text = "Submit",
                            style = TextStyle(color = Color.Black),
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

            }
        }
        TampilData(
            tglBrngkt = tglbrngkt,
            Asal = asal,
            tglDatang = tgldatang,
            Tujuan = tujuan,
            Kelas = kelas
        )
    }

}


@Composable
fun TampilData(tglBrngkt: String, Asal: String, tglDatang: String, Tujuan: String, Kelas: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Detail data",
            style = TextStyle(fontWeight = FontWeight.Bold),
            fontSize = 20.sp
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(size = 25.dp)
            )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)
                .background(color = Color.Black, shape = RoundedCornerShape(size = 15.dp))
        ) {
            Column {


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(text = "Keberangkatan", color = Color.Cyan)
                        Text(
                            text = tglBrngkt.uppercase(), style = TextStyle(fontSize = 16.sp),
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = Asal.uppercase(), style = TextStyle(fontSize = 20.sp),
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = tglDatang.uppercase(),style = TextStyle(fontSize = 16.sp),
                            color = Color.White
                        )
                    }
                    Icon(
                        Icons.Filled.ArrowForward, contentDescription = null,
                        modifier = Modifier, tint = Color.White
                    )

                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(text = "Kedatangan", color = Color.Cyan)
                        // Menampilkan data Keberangkatan, Tanggal Berangkat, Asal Keberangkatan, dan Tanggal Datang secara langsung
                        Text(
                            text = tglBrngkt.uppercase(), style = TextStyle(fontSize = 16.sp),
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = Tujuan.uppercase(), style = TextStyle(fontSize = 20.sp),
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = tglDatang.uppercase(), style = TextStyle(fontSize = 16.sp),
                            color = Color.White
                        )
                    }
                }
                Row (modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Column(
                        modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(text = "Class", color = Color.White)
                        Text(
                            text = Kelas, style = TextStyle(fontSize = 16.sp),
                            color = Color.White, fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.logo_kai),
                        contentDescription = null, modifier = Modifier.padding(horizontal = 15.dp)
                    )
                }
            }

        }
    }
}