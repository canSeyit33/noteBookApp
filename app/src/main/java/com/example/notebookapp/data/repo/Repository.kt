package com.example.notebookapp.data.repo

import com.example.notebookapp.data.dataSource.NoteBookDataSource

class Repository {

    var dts = NoteBookDataSource()



    suspend fun update(newText:String) : String = dts.update(newText)
    suspend fun delete() : String = dts.delete()
}