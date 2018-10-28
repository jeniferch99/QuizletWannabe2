package com.example.jenifer.quizletwannabe2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        // cancel add card
        findViewById(R.id.cancel_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this, MainActivity.class);
                AddCardActivity.this.startActivityForResult(intent, 100);
            }});

        // getting the input for the new flashcard
        findViewById(R.id.save_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(); // create a new Intent, this is where we will put our data
                data.putExtra("question", ((EditText) findViewById(R.id.add_flashcard_question)).getText().toString()); // puts one string into the Intent, with the key as 'string1'
                data.putExtra("answer",((EditText) findViewById(R.id.add_flashcard_answer)).getText().toString()); // puts another string into the Intent, with the key as 'string2
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes this activity and pass data to the original activity that launched this activity
            }
        });
    }
}
