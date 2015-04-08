package aricelio.grupopesquisa.br.contato;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import aricelio.grupopesquisa.br.DataAccess.PessoaDAO;
import aricelio.grupopesquisa.br.DomainModel.Pessoa;
import aricelio.grupopesquisa.br.pessoa.R;


public class Contato extends ActionBarActivity {

    // Método onCreate..............................................................................
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
    }

    // Método Salvar................................................................................
    public void Salvar(View view){

        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO(this);

        // Recupera os componetes da tela
        EditText edNome = (EditText) findViewById(R.id.edtNome);
        EditText edTelefone = (EditText) findViewById(R.id.edtTelefone);
        EditText edEmail = (EditText) findViewById(R.id.edtEmail);

        pessoa.setNome( edNome.getText().toString() );
        pessoa.setEmail( edEmail.getText().toString() );
        pessoa.setTelefone( Integer.parseInt( edTelefone.getText().toString()) );

        pessoaDAO.inserir(pessoa);
        // Mostra uma mensagem na tela com o Toast
        Toast toast = Toast.makeText(this, "Contato Salvo com Sucesso!", Toast.LENGTH_LONG);
        toast.show();
    }


    // Método onCreateOptionsMenu...................................................................
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contato, menu);
        return true;
    }

    // Método onOptionsItemSelected.................................................................
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
