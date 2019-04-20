package br.usjt.ciclodevidagpsemapas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocalizacaoDAO {

    private Context context;
    public LocalizacaoDAO(Context context) {
        this.context = context;
    }

    public List<Localizacao> busca() {
        LocalizacaoDBHelper dbHelper = new LocalizacaoDBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Localizacao> localizacoes = new ArrayList<>();
        String command = String.format(
                Locale.getDefault(),
                "SELECT * FROM %s",
                LocalizacaoContract.LocalizacaoEntity.TABLE_NAME
        );
        Cursor cursor = db.rawQuery(command, null);
        while (cursor.moveToNext()) {
            int idLocalizacao =
                    cursor.getInt(
                            cursor.getColumnIndex(String.format(Locale.getDefault(),
                                    "%s.%s", LocalizacaoContract.LocalizacaoEntity.TABLE_NAME,
                                    LocalizacaoContract.LocalizacaoEntity.COLUMN_NAME_ID)));
            double latitude =
                    cursor.getDouble(cursor.getColumnIndex(
                            String.format(
                                    Locale.getDefault(),
                                    "%s.%s",
                                    LocalizacaoContract.LocalizacaoEntity.TABLE_NAME,
                                    LocalizacaoContract.LocalizacaoEntity.COLUMN_NAME_LATITUDE
                            )
                    ));
            double longitude =
                    cursor.getDouble(
                            cursor.getColumnIndex(
                                    String.format(
                                            Locale.getDefault(),
                                            "%s.%s",
                                            LocalizacaoContract.LocalizacaoEntity.TABLE_NAME,
                                            LocalizacaoContract.LocalizacaoEntity.COLUMN_NAME_LONGITUDE
                                    )
                            )
                    );

            Localizacao localizacao = new Localizacao(idLocalizacao, latitude, longitude);
            localizacoes.add(localizacao);
        }
        cursor.close();
        db.close();
        dbHelper.close();
        return localizacoes;
    }
}
