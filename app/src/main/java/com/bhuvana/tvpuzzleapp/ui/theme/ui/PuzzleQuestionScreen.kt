package com.bhuvana.tvpuzzleapp.ui.theme.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.bhuvana.tvpuzzleapp.model.PuzzleViewModel

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
 fun PuzzleQuestionScreen(puzzleViewModel: PuzzleViewModel)
{

    var question by remember { mutableStateOf(TextFieldValue()) }
    var answer by remember { mutableStateOf(TextFieldValue()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){

        OutlinedTextField(value = question.text, onValueChange = { puzzleViewModel.question},
            label = { Text(" Puzzle Question") },modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),)

        OutlinedTextField(
            value = answer.text,
            onValueChange = {it
            },
            label = { Text("Enter Puzzle Answer") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp))
        Button(
            onClick = {
                if(answer.equals(5))
                {

                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Icon(imageVector = Icons.Default.Check, contentDescription = "Save Puzzle")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Save Puzzle")
        }
    }
    }



