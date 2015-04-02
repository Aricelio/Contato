package aricelio.grupopesquisa.br.DataAccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aricelio on 01/04/15.
 */
public class DBUtil extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String TABELA_CONTATO = "Contatos";
    private static final String DATABASE = "DB_CONTATO";

    // Construtor...................................................................................
    public DBUtil(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    // onCreate.....................................................................................
    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddlContato = "CREATE TABLE " + TABELA_CONTATO + "( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT, "
                + "telefone INT, "
                + "email TEXT )";

        db.execSQL(ddlContato);
    }

    // onUpgrade...................................................................................
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
