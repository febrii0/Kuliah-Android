package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_move_activity) {
            Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
            startActivity(moveIntent);
        } else if (view.getId() == R.id.btn_move_activity_data) {
            Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_KULIAH, "PEMROGRAMAN BERBASIS MOBILE");
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_KELAS, 5);
            startActivity(moveWithDataIntent);
        }
    }
}