package sunpj.loveticket;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class QueryActivity extends AppCompatActivity {
    private OkHttpClient client;
    private String url = "https://leancloud.cn:443/1.1/classes/Ticket?limit=10&&order=-updatedAt&&";

    public static void start(Context context){
        context.startActivity(new Intent(context,QueryActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        client = new OkHttpClient();

        Request request = new Request.Builder()
                .addHeader("X-LC-Id", MainApplication.APP_ID)
                .addHeader("X-LC-Key", MainApplication.APP_KEY)
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("onFailure", "call " + call);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("onResponse", "call " + call + "  " + response.body().string());
            }
        });

    }


}
