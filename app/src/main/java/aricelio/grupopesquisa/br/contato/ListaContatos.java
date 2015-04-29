package aricelio.grupopesquisa.br.contato;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import aricelio.grupopesquisa.br.DataAccess.PessoaDAO;
import aricelio.grupopesquisa.br.DomainModel.Pessoa;
import aricelio.grupopesquisa.br.contato.R;


public class ListaContatos extends ActionBarActivity {

    private ListView mListView;
    private List<Pessoa> listaPessoas;

    // Método onCreate..............................................................................
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        // Ligacao dos componentes de TELA a lista da Activity
        mListView = (ListView) findViewById(R.id.lvListaContatos);
    }

    // Método para carregar a lista................................................
    public void carregarLista() throws Exception {
        ArrayAdapter<Pessoa> adapter;
        int adapterLayout = android.R.layout.simple_list_item_1;

        PessoaDAO pessoaDAO = new PessoaDAO(this);
        this.listaPessoas = pessoaDAO.listar();

        // O objeto ArrayAdapter sabe converter listas ou vetores em View
        adapter = new ArrayAdapter<Pessoa>(this, adapterLayout, listaPessoas);

        // Associacao do Adapter a ListView
        this.mListView.setAdapter(adapter);
        registerForContextMenu(this.mListView);
    }

    // .......................................................................
    @Override
    protected void onResume() {
        try {
            super.onResume();
            this.carregarLista();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método onCreateOptionsMenu...................................................................
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_contatos, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId()==R.id.lvListaContatos) {
            AdapterView.AdapterContextMenuInfo info =
                    (AdapterView.AdapterContextMenuInfo)menuInfo;
            Pessoa pessoa = this.listaPessoas.get(info.position);
            menu.setHeaderTitle(pessoa.getNome());
        }
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
