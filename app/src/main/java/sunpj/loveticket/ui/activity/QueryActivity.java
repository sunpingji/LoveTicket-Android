package sunpj.loveticket.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

import sunpj.loveticket.AppProfile;
import sunpj.loveticket.R;
import sunpj.loveticket.api.TicketApi;
import sunpj.loveticket.bean.TicketResult;

public class QueryActivity extends AppCompatActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context,QueryActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        TicketApi api = new TicketApi(AppProfile.getInstance().getOkHttpClient());
        api.getTickets().enqueue(new retrofit2.Callback<TicketResult>() {
            @Override
            public void onResponse(retrofit2.Call<TicketResult> call, retrofit2.Response<TicketResult> response) {
                Logger.d("onResponse","response "+response);
            }

            @Override
            public void onFailure(retrofit2.Call<TicketResult> call, Throwable t) {
                Logger.d("onFailure","onFailure ");
            }
        });


    }


}
