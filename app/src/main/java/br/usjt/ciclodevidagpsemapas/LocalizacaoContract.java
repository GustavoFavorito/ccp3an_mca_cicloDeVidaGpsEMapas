package br.usjt.ciclodevidagpsemapas;

import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocalizacaoContract {


    private static List<Localizacao> localizacoes;
    static {
        localizacoes = new ArrayList<>();
        localizacoes.add(new Localizacao(1, 1.0, 10.0));
        localizacoes.add(new Localizacao(2, 2.0, 20.0));
        localizacoes.add(new Localizacao(3, 3.0, 30.0));
        localizacoes.add(new Localizacao(4, 4.0, 40.0));
        localizacoes.add(new Localizacao(5, 5.0, 50.0));
    }

    private LocalizacaoContract() {
    }

    public static class LocalizacaoEntity implements BaseColumns {

        public static final String TABLE_NAME = "tb_localizacao";
        public static final String COLUMN_NAME_ID = "id_localizacao";
        public static final String COLUMN_NAME_LATITUDE = "latitude";
        public static final String COLUMN_NAME_LONGITUDE = "longitude";
        public static final String DROP_TABLE = String.format(
                "DROP TABLE %s", LocalizacaoEntity.TABLE_NAME);
    }

    public static String createTableLocalizacao() {
        return String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s FLOAT, %s FLOAT",
            LocalizacaoEntity.TABLE_NAME,
            LocalizacaoEntity.COLUMN_NAME_ID,
            LocalizacaoEntity.COLUMN_NAME_LATITUDE,
            LocalizacaoEntity.COLUMN_NAME_LONGITUDE
        );
    }

    public static String insertLocalizacoes() {

        String template = "INSERT INTO %s (%s, %s, %s) VALUES (%d, %f, %f);";
        StringBuilder sb = new StringBuilder ("");
        for (Localizacao localizacao : localizacoes) {
            sb.append(
                    String.format(
                            Locale.getDefault(),
                            template,
                            LocalizacaoEntity.TABLE_NAME,
                            LocalizacaoEntity.COLUMN_NAME_ID,
                            LocalizacaoEntity.COLUMN_NAME_LATITUDE,
                            LocalizacaoEntity.COLUMN_NAME_LONGITUDE,
                            localizacao.getId(),
                            localizacao.getLatitude(),
                            localizacao.getLongitude()
                    )
            );
        }
        return sb.toString();
    }
}
