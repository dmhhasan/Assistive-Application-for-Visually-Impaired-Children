package cci.assistiveapp.TextToSpeech;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;

import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class TTS implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;

    public TTS(Context context){
        tts = new TextToSpeech(context,this);
        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String s) {

            }

            @Override
            public void onDone(String s) {

            }

            @Override
            public void onError(String s) {

            }
        });
    }

    @Override
    public void onInit(int status) {
        if(status==TextToSpeech.SUCCESS){
            tts.setLanguage(Locale.US);
        }
    }

    public void speak(String txt){
        Random rand = new Random();
        if(txt!=null){
            HashMap<String,String> hashMap = new HashMap<String, String>();
            hashMap.put(""+rand.nextInt(), txt);
            tts.speak(txt,TextToSpeech.QUEUE_FLUSH, hashMap);
        }
    }
}
