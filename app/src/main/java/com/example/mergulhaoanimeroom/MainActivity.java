package com.example.mergulhaoanimeroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static AnimeDAO animeDao; // o DAO
    private Button scrollButton, cadastroButton, limparButton; //os Botões
    private EditText enterNome, enterGenero, enterAno; //os EditTexts

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Associação dos botões

        scrollButton=(Button)findViewById(R.id.scrollButton);
        cadastroButton=(Button)findViewById(R.id.cadastroButton);
        limparButton=(Button)findViewById(R.id.limparButton);

        //Associação dos EditTexts

        enterNome=(EditText)findViewById(R.id.enterNome);
        enterGenero=(EditText)findViewById(R.id.enterGenero);
        enterAno=(EditText)findViewById(R.id.enterAno);


        //Abaixo já está se construindo o banco de dados e já fornecendo o DAO ao objeto animeDAO

        animeDao = Room.databaseBuilder(getApplicationContext(),
                AnimeDatabase.class, "animeDB").allowMainThreadQueries().build()
                .animeDao();


        //Listener do Botão de cadastro

        cadastroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!enterNome.getText().toString().equals("") &&
                !enterGenero.getText().toString().equals("") &&
                !enterAno.getText().toString().equals("")){

                    //Insere uma nova instância da classe anime no banco de dados
                    // com os dados que o usuário digitou

                    animeDao.insert(new Anime(
                            enterNome.getText().toString(),
                            enterGenero.getText().toString(),
                            Integer.parseInt(enterAno.getText().toString())));

                    Toast.makeText(MainActivity.this, "Anime "+enterNome.getText().toString()+"" +
                            " cadastrado com sucesso", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(MainActivity.this, "Inválido", Toast.LENGTH_SHORT).show();

                }

            }
        });

        //Listener do botão para mudar de activity

        scrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecycleActivity.class);
                startActivity(intent);
            }
        });

        //Listener do botão de limpar a lista

        limparButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                animeDao.apagarTudo();

                Toast.makeText(MainActivity.this, "Lista de animes limpa com sucesso", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
