package ru.mirea.markinaa.rumireamarkinlesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.markinaa.rumireamarkinlesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPref	=
                getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);

        String group = sharedPref.getString("GROUP", "Введите номер группы");
        String number = sharedPref.getString("NUMBER" , "Введите номер по списку");
        String like = sharedPref.getString("LIKE", "Введите название " +
                "любимого фильма или сериала");
        binding.editTextTextPersonName.setText(group);
        binding.editTextTextPersonName2.setText(number);
        binding.editTextTextPersonName3.setText(like);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor	editor	=	sharedPref.edit();
                editor.putString("GROUP", binding.editTextTextPersonName.getText().toString());
                editor.putString("NUMBER", binding.editTextTextPersonName2.getText().toString());
                editor.putString("LIKE", binding.editTextTextPersonName3.getText().toString());
                editor.apply();
            }
        });

    }
}