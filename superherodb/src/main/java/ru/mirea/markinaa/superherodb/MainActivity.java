package ru.mirea.markinaa.superherodb;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import ru.mirea.markinaa.superherodb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AppDatabase db = App.getInstance().getDatabase();
        SuperHeroDao superHeroDao = db.superHeroDao();
        SuperHero superHero = new SuperHero();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                superHero.name = binding.editText.getText().toString();
                superHero.superpower = binding.editText2.getText().toString();
                superHeroDao.insert(superHero);
            }
        });
    }
}