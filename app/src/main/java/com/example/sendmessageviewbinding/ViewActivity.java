package com.example.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.sendmessageviewbinding.databinding.ActivityViewBinding;
import com.example.sendmessageviewbinding.model.data.Message;

public class ViewActivity extends AppCompatActivity {

    private ActivityViewBinding binding;
    private Message message;

    public static final String TAG = "ViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //1. Recoger directamente el Intent y el Bundle
        Bundle bundle = getIntent().getExtras();

        //Ejemplo 2: Con Parcelable
        message= bundle.getParcelable(Message.KEY);

        initiliceView();
    }

    //region Ciclo de vida de las Activities
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ViewActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ViewActivity -> onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ViewActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "ViewActivity -> onDestroy()");
    }

    //endregion

    /**
    *Método que inicializa todos las vistas o wodgets de la interfaz o del Layout
    */
    private void initiliceView(){

        String userInfo = message.getSender().getName() + " " + message.getSender().getSurname() + "\n" + message.getSender().getDni() + "\nTe ha mandado un mensaje";
        binding.tvUserInfo.setText(userInfo);
        binding.tvMessage.setText(message.getContent());
    }

}