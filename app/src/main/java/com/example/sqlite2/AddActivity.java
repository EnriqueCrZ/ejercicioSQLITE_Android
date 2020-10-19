package com.example.sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText title_input, author_input, pages_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        author_input = findViewById(R.id.author_input);
        pages_input = findViewById(R.id.pages_inputs);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDB = new DatabaseHelper(AddActivity.this);
                long result = myDB.addBook(title_input.getText().toString().trim(),author_input.getText().toString().trim(),Integer.parseInt(pages_input.getText().toString().trim()));

                if(result == -1)
                    //Toast.makeText(context,"Fallo en agregar registro",Toast.LENGTH_SHORT).show();
                    title_input.setText("");
                else{
                    title_input.setText("");
                    author_input.setText("");
                    pages_input.setText("");
                    //Toast.makeText(context,"Agregado exitosamente",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}