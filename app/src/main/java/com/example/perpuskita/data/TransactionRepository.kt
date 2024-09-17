package com.excal.simplerecyclerview.Data

import com.example.perpuskita.data.Book

class TransactionRepository(private val dao:TransactionDao) {

    suspend fun insert(transaction:Book){
        return dao.insert(transaction)
    }

    suspend fun getAllTransaction():List<Book>{
        return dao.getAllBook()
    }

    suspend fun editTransactionById(targetId:Int,targetBuku:String,targetJudul:String,targetPengarang: String,
                                    targetPinjam:String, targetKembali:String){
        return dao.editBookById(targetId,targetBuku,targetJudul,targetPengarang,targetPinjam,targetKembali)
    }
    suspend fun deleteTransactionById(targetId:Int){
        return dao.deleteBookById(targetId)
    }


}