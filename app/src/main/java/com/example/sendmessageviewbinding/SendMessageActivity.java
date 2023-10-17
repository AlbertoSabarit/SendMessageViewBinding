package com.example.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.example.sendmessageviewbinding.model.data.Message;
import com.example.sendmessageviewbinding.model.data.Person;

public class SendMessageActivity extends AppCompatActivity {
    private ActivitySendMessageBinding binding;
    public static final String TAG = "SendMessageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Expresión Lambda para implementar el evento onClick()

        binding.fab.setOnClickListener(v -> {
            sendMessage();
        });

        Log.d(TAG, "SendMessageActivity -> onCreate()");
    }


        //region Ciclo de vida de las Activities
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }

    //endregion

    /**
     * Método para añadir opciones al Menu superior (3 puntitos)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Método que crea intent que se usa para iniciar una nueva actividad
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about_me) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Método que construye el mensaje y lo envia a otra Acivity
     */
    public void sendMessage() {
        Intent intent = new Intent(this, ViewActivity.class);
        Bundle bundle = new Bundle();
        Person persone = new Person("Alberto", "Sabarit", "44653879T");
        Person persond = new Person("Antonio", "Barba", "44653880R");
        Message message = new Message(1, binding.edMessage.getText().toString(), persone, persond);
        bundle.putParcelable(Message.KEY, message);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}