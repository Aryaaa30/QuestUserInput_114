package com.example.composablelayout3.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.selects.select

@Preview(showBackground = true)
@Composable
fun UserInput(modifier: Modifier = Modifier){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var textNama by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textNoHp by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }

    var jenisJk by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    val dataJK = listOf("L" , "P")

    Column (modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp)
        Spacer(modifier = Modifier.padding(28.dp))

        TextField(
            value = nama,
            onValueChange = {nama = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Nama") },
            placeholder = { Text("Masukkan Nama Anda") }
        )
        Row {
            textJK.forEach {selectedJK ->
                Row {
                    RadioButton(selected = jenisJk == selectedJK,
                        onClick = {
                            jenisJk = selectedJK
                        })
                    Text(selectedJK)
                }
            }
        }
        TextField(
            value = email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Email") },
            placeholder = { Text("Masukkan Email Anda") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = noHp,
            onValueChange = {noHp = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("NoHp") },
            placeholder = { Text("Masukkan NoHp Anda") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Alamat") },
            placeholder = { Text("Masukkan Alamat Anda") }
        )

        Button(onClick = {
            textNama = nama
            textJK = jenisJk
            textEmail = email
            textNoHp = noHp
            textAlamat = alamat
        },
            modifier = Modifier.padding(vertical = 18.dp)){
            Text("Save")
        }

        Card(modifier = Modifier.padding(16.dp)) {
            Column {
                TampilData(
                    judul = "Nama",
                    isinya = textNama
                )
                TampilData(
                    judul = "Jenis Kelamin",
                    isinya = textJK
                )
                TampilData(
                    judul = "Email",
                    isinya = textEmail
                )
                TampilData(
                    judul = "NoHp",
                    isinya = textNoHp
                )
                TampilData(
                    judul = "Alamat",
                    isinya = textAlamat
                )
            }
        }
    }
}
@Composable
fun TampilData(judul:String, isinya:String){
    Row (modifier = Modifier.fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}