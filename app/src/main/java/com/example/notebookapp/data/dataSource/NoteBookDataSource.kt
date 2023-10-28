package com.example.notebookapp.data.dataSource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteBookDataSource {

    suspend fun update(newText:String) : String =
        withContext(Dispatchers.IO){
            return@withContext newText
        }

    suspend fun delete() : String =
        withContext(Dispatchers.IO){
            return@withContext ""
        }

}