package aricelio.grupopesquisa.br.contato;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import aricelio.grupopesquisa.br.DataAccess.PessoaDAO;
import aricelio.grupopesquisa.br.DomainModel.Pessoa;
import aricelio.grupopesquisa.br.contato.R;


public class Contato extends ActionBarActivity {

    // Método onCreate..............................................................................
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
    }

    // Método Salvar................................................................................
    public void Salvar(View view) {

        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO(this);

        // Recupera os componetes da tela
        EditText edNome = (EditText) findViewById(R.id.edtNome);
        EditText edTelefone = (EditText) findViewById(R.id.edtTelefone);
        EditText edEmail = (EditText) findViewById(R.id.edtEmail);

        pessoa.setNome(edNome.getText().toString());
        pessoa.setEmail(edEmail.getText().toString());
        pessoa.setTelefone(Integer.parseInt(edTelefone.getText().toString()));

        pessoaDAO.inserir(pessoa);
        // Mostra uma mensagem na tela com o Toast
        /*Toast toast = Toast.makeText(this, "Contato Salvo com Sucesso!", Toast.LENGTH_LONG);
        toast.show();*/

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Contato salvo com sucesso!")
                .setTitle("Cadastro de Contato");
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

        edEmail.setText("");
        edNome.setText("");
        edTelefone.setText("");
        edTelefone.setBackgroundColor(Color.LTGRAY);
    }
    // Método que abre a tela de listagem de contatos...............................................
    public void AbrirListaContatos(View v){
        Intent intent = new Intent(Contato.this, ListaContatos.class);
        Contato.this.startActivity(intent);
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
