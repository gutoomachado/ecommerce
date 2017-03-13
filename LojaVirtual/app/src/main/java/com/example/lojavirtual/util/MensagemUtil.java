package com.example.lojavirtual.util;

import android.app.Activity;
import android.widget.Toast;

import com.example.lojavirtual.LoginActivity;

/**
 * Created by GuTo on 12/03/2017.
 */

public class MensagemUtil {

    public static void addMsg(Activity activity, String msg){
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

}
