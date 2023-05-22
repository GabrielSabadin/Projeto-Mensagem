package com.example.abrirmensagem;

import org.json.JSONException;
import org.json.JSONObject;

public class Gerar {

    //{"advice_id":49,"advice":"Ein Hemd ohne Buegeleisen buegeln - Wenn Sie kein Buegeleisen haben, haengen Sie Ihre Kleidung im Badezimmer auf, waehrend Sie eine heisse Dusche nehmen. Danach foehnen Sie es mit einem Haartrockner trocken."}

    // Classe para pegar os métodos da API, id e mensagem, e transformar eles em variáveis
    private int advice_id;
    private String advice;

    public Gerar(JSONObject object) throws JSONException {
        this.advice_id = object.getInt("advice_id");
        this.advice = object.getString("advice");
    }

    public int getAdviceId(){ return this.advice_id; }
    public String getAdvice(){ return this.advice; }
}
