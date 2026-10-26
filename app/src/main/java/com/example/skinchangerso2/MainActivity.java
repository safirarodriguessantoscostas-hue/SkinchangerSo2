
package com.example.skinchangerso2;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends Activity {

    LinearLayout layout;
    TextView selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 24, 20, 24);
        layout.setBackgroundColor(Color.rgb(15, 17, 25));
        scroll.addView(layout);

        TextView title = text("SKINCHANGER SO2", 25, Color.WHITE);
        title.setTypeface(null, Typeface.BOLD);
        layout.addView(title);

        layout.addView(text("INVENTÁRIO  •  PRÉVIA DE SKINS", 12,
                Color.rgb(150, 160, 180)));

        addSpace(24);
        layout.addView(text("ARMAS DISPONÍVEIS", 16,
                Color.rgb(90, 190, 255)));

        addSkin("AKR", "Neon Revolution", "LENDÁRIA",
                Color.rgb(180, 65, 255));
        addSkin("M4", "Night Wolf", "ÉPICA",
                Color.rgb(65, 120, 255));
        addSkin("AWM", "Dragon Fire", "MÍTICA",
                Color.rgb(255, 90, 65));
        addSkin("USP", "Cyan Pulse", "RARO",
                Color.rgb(40, 210, 190));
        addSkin("Desert Eagle", "Golden Strike", "ÉPICA",
                Color.rgb(255, 190, 50));

        addSpace(20);
        selected = text("Nenhuma skin selecionada", 16, Color.WHITE);
        layout.addView(selected);

        setContentView(scroll);
    }

    TextView text(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setPadding(0, 8, 0, 8);
        return t;
    }

    void addSkin(String weapon, String skin, String rarity, int color) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(18, 12, 18, 12);
        card.setBackgroundColor(Color.rgb(28, 32, 45));

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 12, 0, 0);
        layout.addView(card, params);

        TextView name = text(weapon + "  •  " + skin, 18, Color.WHITE);
        name.setTypeface(null, Typeface.BOLD);
        card.addView(name);

        TextView label = text(rarity, 12, color);
        card.addView(label);

        TextView button = text("SELECIONAR  →", 14, Color.WHITE);
        button.setGravity(Gravity.CENTER);
        button.setBackgroundColor(color);
        button.setPadding(12, 12, 12, 12);
        card.addView(button);

        button.setOnClickListener(v -> {
            selected.setText("Selecionada: " + weapon + " — " + skin);
            Toast.makeText(this, "Skin selecionada!",
                    Toast.LENGTH_SHORT).show();
        });
    }

    void addSpace(int height) {
        TextView space = new TextView(this);
        space.setHeight(height);
        layout.addView(space);
    }
}
