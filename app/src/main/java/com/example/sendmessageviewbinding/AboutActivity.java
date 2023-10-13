package com.example.sendmessageviewbinding;

import android.content.Context;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.danielstone.materialaboutlibrary.ConvenienceBuilder;
import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;

public class AboutActivity extends MaterialAboutActivity {


    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.title_about); // "Personal Information"
    }

    /**
     * Método para añadir Cards al AboutAcivity
     */

    @Override
    @NonNull
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {
        MaterialAboutCard card = new MaterialAboutCard.Builder()
                .title("Autor")
                .cardColor(ContextCompat.getColor(context, R.color.rosaPastel))
                .addItem(new MaterialAboutActionItem.Builder()
                        .text("Alberto Sabarit")
                        .subText("Alum. módulo DEINT")
                        .icon(R.drawable.ic_action_person)
                        .build())
                .addItem(new MaterialAboutActionItem.Builder()
                        .text("Fork on GitHUB")
                        .icon(R.drawable.ic_action_share)
                        .setOnClickAction(ConvenienceBuilder.createWebsiteOnClickAction(context, Uri.parse("https://github.com/AlbertoSabarit")))
                        .build())
                .build();
        MaterialAboutCard card2 = new MaterialAboutCard.Builder()
                .cardColor(ContextCompat.getColor(context, R.color.rosaPastel))
                .addItem(new MaterialAboutActionItem.Builder()
                        .text("Version")
                        .subText("1.0.0")
                        .icon(R.drawable.ic_action_info)
                        .build())
                .build();


        return new MaterialAboutList.Builder()
                .addCard(card)
                .addCard(card2)
                .build();
    }
}
