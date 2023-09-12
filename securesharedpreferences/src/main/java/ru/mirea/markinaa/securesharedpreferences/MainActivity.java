package ru.mirea.markinaa.securesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.view.View;

import java.io.IOException;
import java.security.GeneralSecurityException;

import ru.mirea.markinaa.securesharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String mainKeyAlias = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        KeyGenParameterSpec keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC;

        try {
            mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SharedPreferences secureSharedPreferences;
        try {
            secureSharedPreferences = EncryptedSharedPreferences.create(
                    "favorite_actor",
                    mainKeyAlias,
                    getBaseContext(),
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
        String result = secureSharedPreferences.getString("secure", "ЛЮБИМЫЙ АКТЕР");
        binding.editTextTextPersonName.setText(result);
        binding.imageView3.setImageDrawable(getResources().getDrawable(R.drawable.burunov,
                null));
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secureSharedPreferences.edit().putString("secure", binding
                        .editTextTextPersonName.getText().toString()).apply();
            }
        });


    }
}