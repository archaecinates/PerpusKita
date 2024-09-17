import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.perpuskita.data.Book

@Dao
 interface TransactionDao {

    @Insert
    suspend fun insert(transaction:Book)

    @Query("SELECT * FROM transaction_table ORDER BY targetId DESC")
    suspend fun getAllBook():List<Book>

    @Query("UPDATE transaction_table SET targetBuku= :targetBuku, targetJudul= :targetJudul," +
            "targetPengarang= :targetPengarang, targetPinjam= :targetPinjam, targetKembali= :targetKembali" +
            " WHERE targetId=:id")
    suspend fun editBookById(id:Int, targetBuku:String, targetJudul:String, targetPengarang:String,
                                    targetPinjam:String, targetKembali:String)

    @Query("DELETE FROM transaction_table WHERE targetId=:id")
    suspend fun deleteBookById(id:Int)

}
