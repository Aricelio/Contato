package aricelio.grupopesquisa.br.DataAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import aricelio.grupopesquisa.br.DomainModel.Pessoa;

/**
 * Created by aricelio on 01/04/15.
 */
public class PessoaDAO {

    // Variaveis....................................................................................
    private Context context;
    private static final String TABELA_CONTATO = "Contatos";

    // Construtor...................................................................................
    public PessoaDAO(Context context) {
        this.context = context;
    }

    // Método Inserir...............................................................................
    public void inserir(Pessoa pessoa){
        // Objeto para armazenar os valores dos campos
        ContentValues values = new ContentValues();

        // Definição dos valores dos campos da tabela
        values.put("nome", pessoa.getNome());
        values.put("telefone", pessoa.getTelefone());
        values.put("email", pessoa.getEmail());

        // Inserção dos dados na tabela Pessoa
        DBUtil bdUtil = new DBUtil(context);
        bdUtil.getWritableDatabase().insert(TABELA_CONTATO, null, values);

        // Fecha a conexão com o banco de dados
        bdUtil.close();

    }

    // Método Listar................................................................................
    public List<Pessoa> listar() throws Exception{

        // Definição da lista de Contatos
        List<Pessoa> lista = new ArrayList<Pessoa>();

        // Definição da Instrução SQL
        String sql = "Select * from Contatos order by id";

        // Objeto que recebe os registros do banco de dados
        DBUtil bdUtil = new DBUtil(context);
        Cursor cursor = bdUtil.getReadableDatabase().rawQuery(sql, null);

        try {
            while (cursor.moveToNext()) {

                Pessoa pessoa = new Pessoa();

                pessoa.setId(cursor.getLong(0));
                pessoa.setNome(cursor.getString(1));
                pessoa.setTelefone(cursor.getInt(2));
                pessoa.setEmail(cursor.getString(3));

                lista.add(pessoa);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {

            // fecha a conexão com o banco
            cursor.close();
            bdUtil.close();
        }
        return lista;
    }
}
